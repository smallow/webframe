<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
    </button>
    <h4 class="modal-title">编辑俱乐部信息</h4>
</div>
<div class="modal-body" style="">
    <form class="form-horizontal" action="${request.contextPath}/group/save" id="add_group_form" method="post">
        <div class="form-group">
            <label for="site_num" class="col-sm-4 control-label">俱乐部名称</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" value="${(group.name)!""}" name="name" id="name">
            </div>
        </div>
        <div class="form-group">
            <label for="site_num" class="col-sm-4 control-label">俱乐部负责人名称</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" value="${(group.masterName)!""}" name="masterName"
                       id="masterName">
            </div>
        </div>
        <div class="form-group">
            <label for="site_num" class="col-sm-4 control-label">俱乐部负责人身份证号</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" value="${(group.masterIdentifyNumber)!""}"
                       name="masterIdentifyNumber" id="masterIdentifyNumber">
            </div>
        </div>
        <div class="form-group">
            <label for="site_num" class="col-sm-4 control-label">负责人手机号</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" value="${(group.masterPhone)!""}" name="masterPhone"
                       id="masterPhone">
            </div>
        </div>
        <div class="form-group">
            <label for="site_num" class="col-sm-4 control-label">管理员</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" value="${(group.adminNickName)!""}" name="adminNickName"
                       id="adminNickName">
            </div>
        </div>

        <input type="hidden" name="id" id="id" value=""/>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default poll-left" data-dismiss="modal">取消</button>
    <button type="button" id="saveBtn" class="btn btn-info" onclick="save()">保存</button>
</div>
<script>

</script>