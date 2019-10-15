$(function () {
  $(".topnav>ul>li:eq(0)").siblings().mouseenter(function () {
    $(this)[0].className = "current"
    $(this).children("div").show();
  })
  $(".topnav>ul>li:eq(0)").siblings().mouseleave(function () {
    $(this).children("div").hide();
    $(this)[0].className = ""
  })
  $(".tools .lang").mouseenter(function () {
    $(this).children("div").show();
  })
  $(".tools .lang").mouseleave(function () {
    $(this).children("div").hide();
  })
  $(".tools .login").mouseenter(function () {
    $(this).children("div").show();
  })
  $(".tools .login").mouseleave(function () {
    $(this).children("div").hide();
  })
  $(".tools .scbtn").click(function () {
    $(this).children("div").show();
  })
  $("#center>.leftbottom .news .title>a").mouseenter(function () {
    $("#center>.leftbottom .newsmore").css({
      "transform": "rotateZ(-180deg)",
      "transition": "all 1s"
    });
  })
  $("#center>.leftbottom .news .title>a").mouseleave(function () {
    $("#center>.leftbottom .newsmore").css({
      "transform": "rotateZ(0deg)",
      "transition": "all 0s"
    });
  })
  $("#search input").blur(function () {
    var search = $("#search")[0];
    setTimeout(function () {
      search.style.display = "none";
    }, 2000);
  })
  var currenttime = new Date();
  Month = currenttime.getMonth() + 1;
  Day = currenttime.getUTCDate();
  $("#center>.leftbottom .news .news-list>ul>div>i").text(Month)
  $("#center>.leftbottom .news .news-list>ul>div>span").text("/" + Day);

  $("#center>.rightbottom .Ticketing  .title>a").mouseenter(function () {
    $("#center>.rightbottom .Ticketing .newsmore").css({
      "transform": "rotateZ(-180deg)",
      "transition": "all 1s"
    });
  })
  $("#center>.rightbottom .Ticketing  .title>a").mouseleave(function () {
    $("#center>.rightbottom .Ticketing .newsmore").css({
      "transform": "rotateZ(0deg)",
      "transition": "all 0s"
    });
  })

  $("#center>.rightbottom .openDay  .title>a").mouseenter(function () {
    $("#center>.rightbottom .openDay .newsmore").css({
      "transform": "rotateZ(-180deg)",
      "transition": "all 1s"
    });
  })
  $("#center>.rightbottom .openDay  .title>a").mouseleave(function () {
    $("#center>.rightbottom .openDay  .newsmore").css({
      "transform": "rotateZ(0deg)",
      "transition": "all 0s"
    });
  })
  // 右边导航
  $(".leftnav>ul>li").mouseenter(function () {
    $(this).children("i").show();
  })
  $(".leftnav>ul>li").mouseleave(function () {
    $(this).children("i").hide();
  })

  $(".leftnav>i").click(function () {
    $(this).children("span").show();
    $(".leftnav>ul").slideUp(200);
  })
  $(".leftnav>i>span").click(function (e) {
    $(".leftnav>ul").slideDown(200);
    $(this).hide();
    e.stopPropagation();
  })
  //所有滑动事件
  window.onscroll = function () {
    // console.log ( getScroll ().scrollLeft, getScroll ().scrollTop );
    if (getScroll().scrollTop > 768) {
      $(".leftnav").show();
    } else {
      $(".leftnav").hide();
    }
  }

  $(window).on("scroll", function () {
    if ($(window).scrollTop() > 100) {
      $("#center>.righttop").animate({top: 0}, 800);
      $("#center>.lefttop").animate({top: 0, opacity: 1}, 1500)
      $("#center>.rightbottom").animate({bottom: 0}, 1300);
      $("#center>.leftbottom").animate({bottom: 0, opacity: 1}, 2500);
      $("#center>img").animate({top: 40, opacity: 1}, 2100);
      $("#center>.rightbottom .Ticketing .VisitTime").animate({width: 462,},
          2000);
      $("#center>.rightbottom .Ticketing  .VisitTime li:eq(0)").animate(
          {opacity: 1}, 5000);
      $("#center>.rightbottom .Ticketing  .VisitTime li:eq(1)").animate(
          {opacity: 1}, 6000);
      $("#center>.rightbottom .Ticketing  .VisitTime li:eq(2)").animate(
          {opacity: 1}, 7000);
      $("#center>.rightbottom .Ticketing  .VisitTime li:eq(3)").animate(
          {opacity: 1}, 8000);
    }
  })

  //获取界面滚出去距离的兼容性封装
  function getScroll() {
    var scrollLeft = window.pageXOffset || document.documentElement.scrollLeft
        || document.body.scrollLeft || 0;
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop
        || document.body.scrollTop || 0;
    return {
      scrollLeft: scrollLeft,
      scrollTop: scrollTop
    }
  }

  // 中间部分转动
  var timeID_you1 = null;
  var rotateDeg_you1 = 0;
  var timeID_you2 = null;
  var rotateDeg_you2 = 0;
  var timeID_you3 = null;
  var rotateDeg_you3 = 0;

  function rotate1() {
    timeID_you1 = setInterval(function () {
      $("#center>.righttop>ul>li:eq(0) img").css(
          {'transform': 'rotate(' + rotateDeg_you1 + 'deg)'});
      rotateDeg_you1 += 1;
    }, 100)
  }

  function rotate2() {
    timeID_you2 = setInterval(function () {
      $("#center>.righttop>ul>li:eq(1) img").css(
          {'transform': 'rotate(' + rotateDeg_you2 + 'deg)'});
      rotateDeg_you2 += 1;
    }, 100)
  }

  function rotate3() {
    timeID_you3 = setInterval(function () {
      $("#center>.righttop>ul>li:eq(2) img").css(
          {'transform': 'rotate(' + rotateDeg_you3 + 'deg)'});
      rotateDeg_you3 += 1;
    }, 100)
  }

  rotate1()
  rotate3()
  rotate2()
  $(".righttop>ul>li:eq(0)").mouseenter(function () {
    clearInterval(timeID_you1);
  })
  $(".righttop>ul>li:eq(1)").mouseenter(function () {
    clearInterval(timeID_you2);
  })
  $(".righttop>ul>li:eq(2)").mouseenter(function () {
    clearInterval(timeID_you3);
  })
  $(".righttop>ul>li:eq(0)").mouseleave(function () {
    rotate1();
  })
  $(".righttop>ul>li:eq(1)").mouseleave(function () {
    rotate2();
  })
  $(".righttop>ul>li:eq(2)").mouseleave(function () {
    rotate3();
  })

  // 顶部大图

  function datumove(img) {
    clearInterval(timeID_datu_you);
    timeID_datu_you = setInterval(function () {
      $(img[index_you]).siblings("li").css(
          {'transform': 'scale(1)', opacity: 1})
      $(img[index_you]).addClass('current').siblings("li").removeClass(
          "current");
      $($("#datu>.dian_you>ul>li")[index_you]).addClass("current").siblings(
          "li").removeClass("current");
      $(img[index_you]).css({'transform': 'scale(' + big_i_you + ')'});
      big_i_you += 0.001;
      if (big_i_you >= 1.1) {
        big_i_you += .25;
        $(img[index_you]).animate({opacity: .01}, 200);
      }
      if (big_i_you >= 1.5) {
        (function () {
          index_you++;
          big_i_you = 1;
          if (index_you >= $(img[index_you]).parent().children("li").length) {
            index_you = 0;
          }
        })()
      }
    }, 100)
  }

  var big_i_you = 1;
  var index_you = 0;
  var that = null;
  var timeID_datu_you = null;
  var timeID1_datu_you = null;
  datumove($("#datu>ul>li"));
  for (var i = 0; i < $("#datu>.dian_you>ul>li").length; i++) {
    $($("#datu>.dian_you>ul>li")[i]).attr('index', i);
  }
  $("#datu>.dian_you>ul>li").click(function () {
    //daTuhide($("#datu>ul>li"));
    big_i_you = 1.1;
    that = this;
    setTimeout(function () {
      //console.log($(this).attr('index'));
      index_you = $(this).attr('index');
      datumove($("#datu>ul>li"));
    }.bind(that), 290);

  })

});
