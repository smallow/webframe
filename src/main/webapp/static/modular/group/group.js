$(function () {
    modalInit("myModal");
    groupGridInit();
});

function groupGridInit() {
    var obj = {
        url: _context + "/group/list",
        columns: [
            {field: "name", title: "俱乐部名称", width: "", height: "", align: "left"},
            {field: "masterName", title: "负责人名称", width: "", height: "", align: "left"},
            {field: "masterIdentifyNumber", title: "负责人证件号码", width: "", height: "", align: "left"},
            {field: "masterPhone", title: "管负责人手机号", width: "", height: "", align: "left"},
            {field: "state", title: "状态", width: "", height: "", align: "left",

            formatter:function (value, row, index) {
                var color="#000";
                if (value == "已开通"){
                    color="#66CD00";
                }else if(value=="已申请"){
                    color="#DC143C";
                }else if(value=="已注销"){
                    color="#0000AA";
                }
                return "<span style='color: "+color+";'>"+value+"</span>";
            }},
            {field: "createDate", title: "创建时间", width: "", height: "", align: "left"},
            {
                field: "operation",
                title: "操作",
                width: "",
                height: "",
                align: "left",
                formatter: function (value, row, index) {
                    return "<a href='javascript:void(0);' onclick=\"modify('" + row.id + "')\">修改</a>&nbsp;|&nbsp;"
                        + "<a href='javascript:void(0);' onclick=\"del('" + row.id + "')\">删除</a>";
                }
            }
        ],
        pageable: true
    };
    groupTable = new DataGrid('group', obj.columns, obj.url, obj.pageable);
    groupTable.datagrid({page:1,pageSize:10});
}

function go() {
    var params = getQueryParams();
    params.page = 1;
    params.pageSize = 10;
    groupTable.load(params);
}

function getQueryParams() {
    var name = $("#name").val();
    var masterName = $("#masterName").val();
    var masterPhone = $("#masterPhone").val();
    var status = $("#status").val();
    var param = {
        name: name,
        masterName: masterName,
        masterPhone: masterPhone,
        status: status
    };
    return param;
}

function pagingImpl(page, size) {
    var params = getQueryParams();
    params.page = page;
    params.pageSize = size;
    groupTable.load(params);
}


function save() {


}