<%-- 
    Document   : admindashboard
    Created on : Jul 10, 2024, 2:27:58 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <!--     SIDE AREA -->
            <div class="sideArea">
                <div class="avatar">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCNOdyoIXDDBztO_GC8MFLmG_p6lZ2lTDh1ZnxSDawl1TZY_Zw" alt="">
                    <div class="avatarName">Welcome,<br>Admin</div>
                </div>
                <ul class="sideMenu">
                    <li><a href=""><span class="fa fa-sitemap"></span>MENU</a></li>
                    <li><a href="javascript:void(0)" class="has-submenu"><span class="fa fa-table"></span>REQUEST PRODUCT</a>
                        <ul class="submenu">
                            <li><a href="index.php?c=product&a=list01"><span class="fa fa-list"></span>Added Product</a></li>
                            <li><a href="index.php?c=product&a=list02"><span class="fa fa-tags"></span>Updated Product</a></li>
                        </ul>
                    </li>                   
                    <li><a href=""><span class="fa fa-money"></span>INVOICE</a></li>
                    <li><a href=""><span class="fa fa-user-o"></span>USER</a></li>
                    <li><a href=""><span class="fa fa-envelope-o"></span>CONTACT</a></li>
                </ul>
            </div>
            <!--     SIDE AREA -->
            <div class="mainArea">
                <!-- BEGIN NAV -->
                <nav class="navTop row">
                    <div class="menuIcon fl"><span class="fa fa-bars"></span></div>
                    <div class="account fr">
                        <div class="name has-submenu">Admin<span class="fa fa-angle-down"></span></div>
                        <ul class="accountLinks submenu">
                            <li><a href="">View website</a></li>
                            <li><a href="">Log out<span class="fa fa-sign-out fr"></span></a></li>
                        </ul>
                    </div>
                </nav>
                <!-- END NAV -->
                <!-- CONTAINER  -->
                <div class="mainContent">  
                    <!-- LIST FORM -->
                    <div class="row filterGroup">
                        <form action="" method="POST" class="formSearch fl">
                            <input type="text" class="inputSearch" placeholder="Search">
                            <button type="submit" class="btnSearch"><i class="fa fa-search"></i></button>
                        </form>
                        <div class="areaFilter fr row">
                            <div class="boxSelect fr">
                                <div class="titleSelect">Sort by</div>
                                <ul class="optionSelect">
                                    <li sortIndex="0"><a href="">Alphabet</a></li>
                                    <li sortIndex="1"><a href="">Price, Ascending</a></li>
                                    <li sortIndex="2"><a href="">Price, Descending</a></li>
                                    <li sortIndex="3"><a href="">Latest</a></li>
                                </ul>
                            </div>
                            <!--         FILTER -->
                            <div class="btnFilter fr bg-fff"><span class="fa fa-filter"></span>Filter</div>
                            <div class="boxFilter">
                                <div class="btnFilter"><span class="fa fa-close"></span>Close</div>
                                <!--             GROUP -->
                                <div class="groupInput">
                                    <select name="">
                                        <option value="">Brand</option>
                                        <option value="">Brand 01</option>
                                        <option value="">Brand 02</option>
                                    </select> 
                                    <select name="">
                                        <option value="">Category</option>
                                        <option value="">Category 01</option>
                                        <option value="">Category 02</option>
                                    </select>
                                    <select name="">
                                        <option value="">Author</option>
                                        <option value="">Author 01</option>
                                        <option value="">Author 02</option>
                                    </select>
                                </div>
                                <!--             END GROUP -->             
                                <!--             GROUP -->
                                <div class="groupInput">
                                    <p class="titleInput">Price</p> 
                                    <div id="filterPrice"></div>
                                    <div class="areaValue">
                                        <p>From</p>
                                        <input type="text" class="rangeValue">
                                        <p>To</p>
                                        <input type="text" class="rangeValue">
                                    </div>
                                </div>
                                <!--             END GROUP -->             
                            </div>
                        </div>
                    </div>
                    <form action="" method="GET" name="listForm" class="form scrollX">
                        <div class="formHeader row">
                            <h2 class="text-1 fl">Product List</h2>
                            <div class="fr">
                                <button type="submit" class="btnSave bg-1 text-fff text-bold fr">SAVE</button><a href="" class="btnAdd fa fa-plus bg-1 text-fff"></a>
                            </div>
                        </div>
                        <div class="table">
                            <div class="row bg-1">
                                <div class="cell cell-50 text-center text-fff">ID</div>
                                <div class="cell cell-100 text-center text-fff">AUTHOR</div>
                                <div class="cell cell-100 text-fff">PUBLISHER</div>
                                <div class="cell cell-200 text-fff">NAME</div>
                                <div class="cell cell-100p text-fff">USER</div>

                                <div class="cell cell-100 text-center text-fff">STATUS</div>
                                <div class="cell cell-100 text-center text-fff">EDIT</div>
                            </div>
                            <ul>
                                <c:forEach var="book" items="${bookList}">
                                    <li class="row">
                                        <div class="cell cell-50 text-center">${book.bookId}</div>
                                        <div class="cell cell-100 text-center">${book.author}</div>
                                        <div class="cell cell-100">${book.publisher}</div>
                                        <div class="cell cell-200"><a href="#">${book.bookName}</a></div>
                                        <div class="cell cell-100p"><a href="#">${book.user.name}</a></div>

                                        <div class="cell cell-100 text-center">${book.status == 1 ? 'Pending' : book.status == 2 ? 'Approved' : 'Rejected'}</div>
                                        <div class="cell cell-100 text-center">
                                            <a href="request?action=edit&bookId=${book.bookId}" class="btnEdit fa fa-pencil bg-1 text-fff"></a>
                                            <a href="request?action=delete&bookId=${book.bookId}" class="btnRemove fa fa-remove bg-1 text-fff" onclick='return confirm("Do you really want to remove it ?")'></a>

                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </form>

                    <!-- DETAIL FORM -->
                    <form action="request" method="POST" class="form">
                        <input type="hidden" name="action" value="updateStatus" >
                        <div class="formHeader row">
                            <h2 class="text-1 fl">Product Detail</h2>
                            <div class="fr">
                                <button type="submit" class="btnSave bg-1 text-fff text-bold fr" >SAVE</button>
                            </div>
                        </div>
                        <div class="formBody row">
                            <div class="column s-6">
                                <label class="inputGroup">
                                    <span>ID</span>
                                    <span><input type="text" name="bookId" value="${book.bookId}" readonly></span>
                                </label>
                                <label class="inputGroup">
                                    <span>Author</span>
                                    <span><input type="text" value="${book.author}" readonly></span>
                                </label>
                                <label class="inputGroup">
                                    <span>Publisher</span>
                                    <span><input type="text" value="${book.publisher}" readonly></span>
                                </label>
                                <label class="inputGroup">
                                    <span>Name</span>
                                    <span><input type="text" value="${book.bookName}" readonly></span>
                                </label>
                                <label class="inputGroup">
                                    <span>User Name</span>
                                    <span><input type="text" value="${book.user.name}" readonly></span>
                                </label>
                            </div>
                            <div class="column s-6">
                                <label class="inputGroup">
                                    <span>Price</span>
                                    <span><input type="text" value="${book.price}" readonly></span>
                                </label>
                                <label class="inputGroup">
                                    <span>Stock Quantity</span>
                                    <span><input type="text" value="${book.stockQuantity}" readonly></span>
                                </label>
                                <label class="inputGroup">
                                    <span>Status</span>
                                    <span>
                                        <select name="status">
                                            <option value="1" ${book.status == 1 ? 'selected' : ''}>Pending</option>
                                            <option value="2" ${book.status == 2 ? 'selected' : ''}>Approved</option>
                                            <option value="3" ${book.status == 3 ? 'selected' : ''}>Rejected</option>
                                        </select>
                                        <i class="btnNewInput fa fa-plus bg-1 text-fff"></i>
                                    </span>
                                </label>
                            </div>
                            <div class="column">
                                <label class="inputGroup">
                                    <span>Description</span>
                                    <textarea readonly>${book.description}</textarea>
                                </label>
                            </div>
                        </div>
                    </form>

                    <div id="pagination">
                        <ul class="pagination list-inline text-center">
                            <li><a href="?page=1">1</a></li>
                            <li class="is-active"><a href="?page=2">2</a></li>
                            <li><a href="?page=3">3</a></li>
                            <li><a href="?page=4">4</a></li>
                            <li><a href="?page=5">5</a></li>
                        </ul>
                    </div>  
                </div>
                <!-- END CONTAINER  -->
            </div>
        </div>





    </body>

    <script type="text/javascript">
        // ELEMENT
        function elm(x) {
            var target = x.substring(1);
            var type = x.charAt(0);
            if (type == '#') {
                return document.getElementById(target);
            } else if (type == '.') {
                return document.getElementsByClassName(target);
            } else {
                return document.getElementsByTagName(x);
            }
        }

// ACCOUNT CLICK
        window.onclick = function () {
            elm(".accountLinks")[0].style.display = 'none';
        };

// SUB MENU
        if (elm(".has-submenu")) {
            for (var i = 0, len = elm(".has-submenu").length; i < len; i++) {
                elm(".has-submenu")[i].onclick = function (e) {
                    e.stopPropagation();
                    toggle(this.nextElementSibling);
                }
            }
        }

// BTN SWITCH
        if (elm(".checkAll") != undefined) {
            for (var i = 0, len = elm(".checkAll").length; i < len; i++) {
                var target = elm(".checkAll")[i].getAttribute("target");
                if (elm(target)[i] != undefined) {
                    elm(".checkAll")[i].onchange = function () {
                        var checked = this.checked;
                        for (var i = 0, len = elm(target).length; i < len; i++) {
                            elm(target)[i].checked = checked;
                        }
                    }
                }
            }
        }

// MENU ICON CLICK
        if (elm(".menuIcon")) {
            elm(".menuIcon")[0].onclick = function () {
                elm(".container")[0].classList.toggle("is-click");
            };
        }

// INPUT IMG
        function getImg(x) {
            if (x.files.length > 0) {
                var fr = new FileReader();
                var imgSrc = null;
                var parent = x.parentElement;
                fr.onload = function (e) {
                    imgSrc = e.target.result;
                    if (parent.getElementsByTagName("img").length > 0) {
                        parent.removeChild(parent.getElementsByTagName("img")[0]);
                    }
                    var img = document.createElement("img");
                    img.setAttribute("src", imgSrc);
                    img.style.width = "80px";
                    img.style.verticalAlign = "top";
                    parent.appendChild(img);
                }
                fr.readAsDataURL(x.files[0]);
            }
        }

// NEW INPUT
        for (var i = 0, len = elm(".btnNewInput").length; i < len; i++) {
            elm(".btnNewInput")[i].onclick = function () {
                findClosest(this, elm(".inputGroup")).nextElementSibling.classList.remove("hide");
            };
        }

// SUB LIST
        if (elm(".btnCaret")) {
            for (var i = 0, len = elm(".btnCaret").length; i < len; i++) {
                elm(".btnCaret")[i].onclick = function () {
                    var row = findClosest(this, elm(".row"));
                    row.classList.toggle("is-active");
                }
            }
        }
        if (elm(".caretAll")) {
            for (var i = 0, len = elm(".caretAll").length; i < len; i++) {
                elm(".caretAll")[i].onchange = function () {
                    var stt = this.checked;
                    var table = findClosest(this, elm(".table"));
                    var row = findChildren(table, elm(".row"));
                    for (var i = 0, len = row.length; i < len; i++) {
                        if (stt) {
                            row[i].classList.add("is-active");
                        } else {
                            row[i].classList.remove("is-active");
                        }
                    }
                }
            }
        }

// SORT
        if (elm(".titleSelect") != undefined) {
            for (var i = 0, len = elm(".titleSelect").length; i < len; i++) {
                elm(".titleSelect")[i].onclick = function (e) {
                    e.stopPropagation();
                    this.classList.toggle("is-active");
                }
            }
        }
        window.onclick = function () {
            for (var i = 0, len = elm(".titleSelect").length; i < len; i++) {
                elm(".titleSelect")[i].classList.remove("is-active");
            }
        }


// FILTER
        if (elm('.btnFilter') != undefined) {
            for (var i = 0, len = elm('.btnFilter').length; i < len; i++) {
                elm('.btnFilter')[i].onclick = function () {
                    elm('.boxFilter')[0].classList.toggle('is-active');
                }
            }
        }

// PRICE BAR
        var slider = document.getElementById('filterPrice');
        var rangeValue = document.getElementsByClassName('rangeValue');

        noUiSlider.create(slider, {
            start: [0, 100],
            connect: true,
            range: {
                'min': 0,
                'max': 100
            }
        });

        slider.noUiSlider.on('update', function (values) {
            for (var i = 0, len = values.length; i < len; i++) {
                rangeValue[i].setAttribute('value', values[i]);
            }
            values = values.map(function (x) {
                return parseInt(x);
            });
            // AJAX HERE
//     $.ajax({
//         url: 'ajax.php',
//         type: 'GET',
//         data: {},
//         success: function(){

//         }
//     });  
        });

        for (var i = 0, len = rangeValue.length; i < len; i++) {
            rangeValue[i].addEventListener('change', function () {
                var v = [];
                for (var i = 0, len = rangeValue.length; i < len; i++) {
                    v[i] = rangeValue[i].value;
                }
                slider.noUiSlider.set(v);
                // AJAX HERE
                console.log(v);
            });
        }

        var noUihandle = elm('.noUi-handle');
        if (noUihandle != undefined) {
            for (var i = 0, len = noUihandle.length; i < len; i++) {
                noUihandle[i].addEventListener('click', function () {
                    var v = slider.noUiSlider.get();
                    // AJAX HERE
                    console.log(v);
                });
            }
        }

//FIND PARENT
        function findClosest(x, parent) {
            do {
                if (parent.length > 0) {
                    for (var i = 0, len = parent.length; i < len; i++) {
                        if (x.isSameNode(parent[i])) {
                            return x;
                        }
                    }
                } else {
                    if (x.isSameNode(parent)) {
                        return x;
                    }
                }
            } while (x = x.parentElement);
        }

// FIND CHILDREN
        function findChildren(x, y) {
            var arr = [];
            if (y.length > 0) {
                for (var i = 0, len = y.length; i < len; i++) {
                    if (x.isSameNode(findClosest(y[i], x))) {
                        arr.push(y[i]);
                    }
                }
            } else {
                if (x.isSameNode(findClosest(y, x))) {
                    arr.push(y);
                }
            }
            return arr;
        }

//RENDER HTML
        function renderHTML(x, content) {
            var tag = document.createElement(x);
            tag.append(content);
            return tag;
        }

//TOGGLE
        function toggle(x) {
            var css = window.getComputedStyle(x, null);
            if (css.getPropertyValue("display") == 'none') {
                x.style.display = 'block';
            } else {
                x.style.display = 'none';
            }
        }


//SLIDE	
        function slideToggle(el) {
            var elCss = window.getComputedStyle(el, null);
            if (elCss.getPropertyValue("height") == 0 + 'px') {
                el.style.height = el.scrollHeight + "px";
            } else {
                el.style.height = 0;
            }
        }

        function extend(o1, o2) {
            if (o1 instanceof Array) {
                var result = [];
                // RESULT = O1
                for (var i = 0, len = o1.length; i < len; i++) {
                    result.push(o1[i]);
                }
                // RESULT = O2
                for (var i = 0, len = o2.length; i < len; i++) {
                    if (result.indexOf(o2[i]) < 0) {
                        result.push(o2[i]);
                    }
                }
            } else if (typeof o1 == 'object') {
                var result = {};
                var o1Keys = Object.keys(o1);
                for (var i = 0, len = o1Keys.length; i < len; i++) {
                    result[o1Keys[i]] = o1[o1Keys[i]];
                }
                var o2Keys = Object.keys(o2);
                for (var i = 0, len = o2Keys.length; i < len; i++) {
                    result[o2Keys[i]] = o2[o2Keys[i]];
                }
            }
            return result;
        }
        function extend2(o1, o = []) {
            var result = o1;
            for (var i = 0, len = o.length; i < len; i++) {
                var result = extend(result, o[i]);
            }
            return result;
        }





// console.log(findClosest(elm("#test"),elm("ul")));


    </script>

</html>
