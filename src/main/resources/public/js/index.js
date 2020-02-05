// layui初始化(必须)
layui.use('element', function () {
    var element = layui.element;
});

// 获取数据
function getData(url,data) {
    var temp;
    $.ajax({
        type: 'get',
        url: url,
        data: data ? data : {},
        async: false,
        success: function (data) {
            if (data){
                // console.log(data);
                temp = data;
            }else {
                temp = null;
            }
        }
    });
    return temp;
}
// 重载select中的数据
function reloadSelect(selector,data){
    var obj = $(selector);
    obj.find('option:not(:nth-child(1))').remove();
    for (var i = 0;i < data.length;i ++){
        var item = data[i];
        var option = obj.find('option:nth-child(1)').clone();
        option.attr('class','');
        option.text(item.name);
        option.val(item.id);
        obj.append(option);
    }
}
// 批量重载
function reloadSelectAll(data) {
    for (var item in data){
        reloadSelect(item,data[item]);
    }
}


// 实例化表格封装  ok
function tableInstance(table,url,cols){
    cols.unshift({type: 'checkbox', fixed: 'left'});
    cols.push({fixed: 'right', title: '操作', width: 165, align: 'center', toolbar: '#bar'});
    // 表格实例化    queryData.url
    return table.render({
        elem: '#table'
        , loading: true
        , height: 390
        , toolbar: 'default'
        , url: url
        , page: true //开启分页
        , cols: [cols]
    });
}
//监听工具栏事件  ok
function listenTool(table,form,queryUrl,updateUrl,delUrl,insertUrl) {
    //监听头工具栏事件
    table.on('toolbar(table)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                if (!insertUrl)
                    layer.msg('此功能暂未开发');
                else location.href = insertUrl;
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    // layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    var updateIndex = openDiv(form,queryUrl,checkStatus.data[0].id,['1000px']);
                    if (updateUrl != null)
                        updateSubmit(form,updateIndex,updateUrl);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    var idList = [];
                    for (var i = 0; i < data.length; i++) {
                        idList.push(data[i].id);
                    }
                    delAction(delUrl,idList);
                }
                break;
        }
    });
    //监听行工具事件
    table.on('tool(table)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'del') {
            layer.confirm('确认删除？', function (index) {
                //向服务端发送删除指令
                delAction(delUrl,[data.id]);
            });
        } else if (layEvent === 'edit') {
            // layer.msg('编辑操作');
            var updateIndex = openDiv(form,queryUrl,data.id,['1000px']);
            if (updateUrl != null)
                updateSubmit(form,updateIndex,updateUrl);
        }
    });
}
// 监听查询表单提交     ok
function querySubmit(form,tableIns) {
    form.on('submit(querySubmit)', function (data) {
        // layer.msg(JSON.stringify(data.field));
        var field = data.field;
        tableIns.reload({
            where: field,
            page: {
                curr: 1
            }
        });
        return false;
    });
}
// 更新提交 ok
function updateSubmit(form,updateIndex,url){
    form.on('submit(updateSubmit)', function (data) {
        // layer.msg(JSON.stringify(data.field));
        data.field.id = $('#update').attr('data-id');
        $.ajax({
            type: 'post',
            url: url,
            data: data.field,
            success: function (data) {
                if (data) {
                    layer.close(updateIndex);
                    $('#query').click();
                    layer.msg('修改成功');
                } else {
                    layer.msg('修改失败,' + data.msg);
                }
            }
        });
        return false;
    });
}
// 删除   ok
function delAction(delUrl,idList) {
    $.ajax({
        type: 'get',
        url: delUrl,
        data: {
            idList: idList
        },
        success: function (data) {
            if (data) {
                $('#query').click();
                layer.msg('删除成功');
            }
        }
    });
}
// 弹出框封装    ok
function openDiv(form,queryUrl,id) {
    var data = getData(queryUrl,{id:id});
    console.log(data);
    var updateForm = $('#update');
    $('.list').empty();
    updateForm.attr('data-id', id);
    if (data && 'head' in data){
        $('#img').attr('src',data.head);
    }
    if (data && 'img' in data){
        $('#img').attr('src',data.img);
    }
    var updateIndex = layer.open({
        title: '修改',
        type: 1,
        area: ['1000px','500px'],
        shade: 0,
        resize: false,
        maxWidth: 800,
        content: updateForm
    });
    updateForm[0].reset();
    form.val("updateForm", data);
    return updateIndex;
}