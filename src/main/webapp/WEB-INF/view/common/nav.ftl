<div class="col-md-2 column" id="leftNav">
    <div class="panel-group" id="panel-29368">


    </div>
</div>
<script>
    $(function () {
        $.post("/getMenus", {}, function (data) {
            $.each(data, function (index, val) {
                var root = $("<div class='panel panel-default'>\n" +
                        "            <div class='panel-heading'>\n" +
                        "                <a class='panel-title collapsed' data-toggle='collapse' data-parent='#panel-29368'\n" +
                        "                   href='#panel-element-" + val.id + "'><span class='glyphicon glyphicon-th-list'></span>" + val.name + "</a>\n" +
                        "            </div>" +
                        "<div id='panel-element-" + val.id + "' class='panel-collapse collapse in'></div>" +
                        "</div>");
                $("#panel-29368").append(root);
                var children = val.children;
                var parentId = "panel-element-" + val.id;
                var parent = $("#"+parentId);
                $.each(children, function (index, val) {
                    var child = $("<div class='panel-body'>\n" +
                            "                    <div class='list-group'>\n" +
                            "                        <a href='${ctxPath}/" + val.url + "' class='list-group-item'>" + val.name + "</a>\n" +
                            "                    </div>\n" +
                            "      </div>");
                    parent.append(child);
                });
            });
        }, 'json');

    });
</script>