// $(function(){
//     alert("2");
//     var $navHeaderLink = $("#publicTpl .panel-group .panel-body .list-group>a");
//     var $navDiv = $("#publicTpl .panel-default");
//
//     $navHeaderLink.on('click',function(){
//         var $linkListParents = $(this).parents(".panel-collapse");
//         if($linkListParents.hasClass("in")){
//             var $index = $linkListParents.parents(".panel-default").index();
//             localStorage.setItem("commonLeftNavIndex",$index)
//         }
//
//     });
//     var $navIndex = parseInt(localStorage.getItem('commonLeftNavIndex'));
//     $navDiv.eq($navIndex).find(".panel-collapse").addClass("in").parents(".panel-default").siblings().find(".panel-collapse").removeClass("in");
// });
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
            var parent = $("#" + parentId);
            $.each(children, function (index, val) {
                var child = $("<div class='panel-body'>\n" +
                    "                    <div class='list-group'>\n" +
                    "                        <a href='" + ctxPath + val.url + "' class='list-group-item'>" + val.name + "</a>\n" +
                    "                    </div>\n" +
                    "      </div>");
                parent.append(child);
            });
        });
    }, 'json');
});


