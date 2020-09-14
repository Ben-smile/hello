
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        ul span{
            cursor:pointer;
        }

        ul{
            font-size: 20px;
            color: #008c8c;
        }

        li{
            margin-top:6px;
            margin-bottom:4px;
        }
        body{
            padding-top: 40px;
            padding-left: 50px;
        }
        ul li{
            list-style: none;

        }
        #active{
            background-color: #cccccc;
        }

        ul a{
            padding: 10px;
            display: inline-block;
            margin-right: 5px;
            margin-top: 1px;
        }

        a.open{
            background:url("image/open.jpg") no-repeat;
        }
        a.close{
            background:url("image/close.jpg") no-repeat;
        }
    </style>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script>

        //相当于js 的window.onload
        $(function () {
            $.post(
                'menuList.do',  //url
                //{uname:'',upass:''} 参数
                //回调函数
                function (data) {
                    //data里面装着所有的menu信息 List<Menu>
                    //将所有的menu信息展示在页面上
                    //因为菜单信息 有层级关系
                    //要想将第一层菜展示就要先将它的子菜单展示
                    //可以用递归来实现
                    //html代码 每一层菜单都是
                    //ul li span菜单名字--->ur li span菜单名字
                    //所以定义一个方法 用来显示当前位置的子菜单
                    //传递两个参数  1.父级菜单的编号 2.父级菜单的位置
                    function showMenuList(pno,$position) {
                        //创建一个ul
                        var ul = $('<ul>');
                        $position.append(ul);//将ul装入指定的父级标签里

                        for (var i = 0;i<data.length;i++) {
                            var menu = data[i];
                            //循环遍历list 如果有一个menu的父及编号等于 传入的 父及编号
                            //说明 这个menu 就是这个 父级菜单的子菜单
                            if (menu.pno == pno){
                                //创建一个li
                                var li = $('<li>');
                                ul.append(li);//将li装入父级菜单

                                //创建菜单的名称
                                var span = $('<span mno="'+menu.mno+'">'+menu.mname+'</span>');

                                li.append(span);
                                //递归寻找这个子菜单的子菜单
                                showMenuList(menu.mno,li);
                            }
                        }
                    }

                    //先展示body标签的子菜单  也就是第一层菜单
                    showMenuList(-1,$('body'));

                    //给菜单添加动画
                    // $('ul span').click(function () {
                    //     $(this).next().toggle(1000);
                    //     //一秒完成上下展开
                    // });

                    //给菜单添加一个单击事件
                    $('ul span').click(function () {
                        $('#active').attr('id','');//取消之前的选中状态
                        $(this).attr('id','active');
                    });


                    //双击修改
                    addDoubleClick($('ul span'));

                    //为所有父级菜单 添加展开合并 图标
                    $('ul span').before('<a>');
                    $('ul a').each(function (i,e) {
                        //e 代表每一个a 标签对象
                        var ul = $(e).parent().children('ul');
                        if (ul.children().length >0){
                            //说明还有子菜单
                            $(e).addClass('open');
                        }
                    });

                    //给图标增加点击事件
                    $('ul a').click(function () {
                        var flag = $(this).attr('class');
                        if (flag == null || flag == undefined){
                            //说明没有子菜单了 不能展开合并
                            return ;
                        }else if (flag == "open"){
                            //可以展开合并
                            //当前是展开状态
                            $(this).next().next().toggle(1000);//一秒完成上下展开
                            $(this).removeClass('open');
                            $(this).addClass('close');

                        }else{
                            //d当前是 关闭状态
                            $(this).next().next().toggle(1000);//一秒完成上下展开
                            $(this).removeClass('close');
                            $(this).addClass('open');
                        }

                    });
                },
                'json'
            );
        });

        //设计方法 用来创建一个根菜单
        function addRootMenu() {
            //同一时间只能有一个 添加框
            if ($('#mname').length != 0){
                return ;
            }
            //这里我们想到 新建子菜单 的保存操作也是一样 就写一个保存的方法共用
            var li = $('<li><input id="mname" placeholder="菜单名称">\n' +
                '        <input id="mhref" placeholder="菜单请求">\n' +
                '        <input id="mtarget" placeholder="菜单位置">' +
                '        <button id="saveBtn" type="submit">提交</li>');
            $('ul:first').append(li);

            $('#saveBtn').click(function () {
                //调用保存方法
                saveMenu(-1);
            })
        }


        //设计一个方法 用来创建一个子菜单
        //参数 1.父级菜单的jquery对象
        function addChildMenu() {
            //获取父级菜单的jquery对象
            var span = $('#active');
            //判断是否选中了标签
            if (span.length == 0){
                confirm("请选择要添加到的标签")
                return ;
            }
            if ($('#mname').length != 0){
                return ;
            }
            var li = $('<li><input id="mname" placeholder="菜单名称">\n' +
                '        <input id="mhref" placeholder="菜单请求">\n' +
                '        <input id="mtarget" placeholder="菜单位置">' +
                '        <button id="saveBtn" type="submit">提交</li>');
            var ul = span.next();
            ul.append(li);
            $('#saveBtn').click(function () {
                //调用保存方法 btn   li     ul        span
                var pno = $(this).parent().parent().prev().attr('mno');
                saveMenu(pno);

            })

        }

        //删除菜单
        //参数 mno
        function deleteMenu() {
            var span = $('#active');
            // if ( = 0){
            //     return ;
            // }
            var f = confirm("确认删除");
            if (!f) return ;
            var mno = span.attr('mno');
            $.post(
                'deleteMenu.do',
                {mno:mno},
                function () {
                    alert("删除成功")
                    span.parent().remove();
                }
            );
        }

        //双击修改方法 方便多处使用
        //参数 当前点击的菜单的jquery对象
        function addDoubleClick($menu) {
            $menu.dblclick(function () {
                if ($('#mname').length != 0) {
                    confirm('请不要重复选择');
                    return;
                }
                //先获取修改的信息
                var span = $(this);
                var mno = span.attr('mno');

                $.post(
                    'selectOneMenu.do',
                    {mno:mno},
                    function (menu) {
                        var mname = menu.mname;
                        var mhref = "";
                        if(menu.mhref != null){
                            mhref = menu.mhref;
                        }
                        var mtarget = "";
                        if (menu.mtarget != null){
                            mtarget = menu.mtarget;
                        }
                        //清空这个span
                        span.empty();
                        var li = $('<li><input id="mname" placeholder="'+mname+'">\n' +
                            '        <input id="mhref" placeholder="'+mhref+'">\n' +
                            '        <input id="mtarget" placeholder="'+mtarget+'">' +
                            '        <button id="saveBtn" type="submit">提交</li>');
                        //加入修改的输入框
                        span.append(li);
                        $('#saveBtn').click(function () {
                            var mname = $('#mname').val();
                            var mhref = $('#mhref').val();
                            var mtarget = $('#mtarget').val();
                            $.post(
                                'updateMenu.do',
                                {mno: mno, mname: mname, mhref: mhref, mtarget: mtarget},
                                function () {
                                    span.empty();
                                    span.attr('mno',mno)
                                    span.append(mname);
                                }
                            );
                        });
                    },
                    'json'
                );


            });
        }

        //保存菜单的方法
        //需要参数
        //1.父级菜单编号 pno
        function saveMenu(pno) {
            var mname = $('#mname').val();
            var mhref = $('#mhref').val();
            var mtarget = $('#mtarget').val();

            if (mname == ""){
                confirm("请输入菜单名称");
                return ;
            }
            //发送请求到后端 保存
            //发送ajax请求
            $.ajax({
                url:'addMenu.do',      //url
                data:{pno:pno,mname:mname,mhref:mhref,mtarget:mtarget},          //参数
                type:'post',        //发送请求的类型
                //dataType:'json',        //返回值类型 默认String
                success:function (mno) {  //成功时的回调函数
                    //删除之前的输入框
                    var li = $('#mname').parent();
                    li.empty();//清除里面的组件
                    li.append('<span mno="'+mno+'">'+mname+'</span>');
                    //给新菜单添加单击事件
                    $('li span').click(function () {
                        $('#active').attr('id','');//取消之前的选中状态
                        $(this).attr('id','active');
                    });
                    //给新建的菜单 添加双击修改事件
                    addDoubleClick($('li span'));

                },
                error:function () {  //失败时的回调函数 xhr.status = 200,404,405,500
                    alert("error")
                }
            });
        }
    </script>
</head>
<body>
    <div>
        <a href="javascript:addRootMenu()">新建根菜单</a>
        <a href="javascript:addChildMenu()">新建子菜单</a>
        <a href="javascript:deleteMenu()">删除菜单</a>
    </div>
    <%--ul>
        <li>
            <span>菜单名称</span>
            <li><span>菜单名称</span></li>
            <li><span>菜单名称</span></li>
            <li><span>菜单名称</span></li>
        </li>
        <li><span>菜单名称</span></li>
        <li><span>菜单名称</span></li>

    </ul--%>
</body>
</html>
