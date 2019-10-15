$(function () {

//顶部导航栏鼠标移入事件
  //导览
  $("#topNavHL .navHL>.daolang").on("mouseenter", function () {
    $("#topNavHL>.daolangHL").css("display", "block");
  });
  $("#topNavHL .navHL>.daolang").on("mouseleave", function () {
    $("#topNavHL>.daolangHL").css("display", "none");
  });
  //展览
  $("#topNavHL .navHL>.zhanlang").on("mouseenter", function () {
    $("#topNavHL>.zhanlangHL").css("display", "block");
  });
  $("#topNavHL .navHL>.zhanlang").on("mouseleave", function () {
    $("#topNavHL>.zhanlangHL").css("display", "none");
  });
  //教育
  $("#topNavHL .navHL>.jiaoyu").on("mouseenter", function () {
    $("#topNavHL>.jiaoyuHL").css("display", "block");
  });
  $("#topNavHL .navHL>.jiaoyu").on("mouseleave", function () {
    $("#topNavHL>.jiaoyuHL").css("display", "none");
  });
  //探索
  $("#topNavHL .navHL>.tansuo").on("mouseenter", function () {
    $("#topNavHL>.tansuoHL").css("display", "block");
  });
  $("#topNavHL .navHL>.tansuo").on("mouseleave", function () {
    $("#topNavHL>.tansuoHL").css("display", "none");
  });
  //学术
  $("#topNavHL .navHL>.xueshu").on("mouseenter", function () {
    $("#topNavHL>.xueshuHL").css("display", "block");
  });
  $("#topNavHL .navHL>.xueshu").on("mouseleave", function () {
    $("#topNavHL>.xueshuHL").css("display", "none");
  });
  //文创
  $("#topNavHL .navHL>.wenchuang").on("mouseenter", function () {
    $("#topNavHL>.wenchuangHL").css("display", "block");
  });
  $("#topNavHL .navHL>.wenchuang").on("mouseleave", function () {
    $("#topNavHL>.wenchuangHL").css("display", "none");
  });
  //关于
  $("#topNavHL .navHL>.guanyu").on("mouseenter", function () {
    $("#topNavHL>.guanyuHL").css("display", "block");
  });
  $("#topNavHL .navHL>.guanyu").on("mouseleave", function () {
    $("#topNavHL>.guanyuHL").css("display", "none");
  });

  //给每个隐藏导航栏也添加鼠标移入(显示)移出(隐藏)事件
  $("#topNavHL>.hideBar").on("mouseenter", function () {
    $(this).css("display", "block");
  });
  $("#topNavHL>.hideBar").on("mouseleave", function () {
    $(this).css("display", "none");
  });

  //给每个隐藏导航栏的li标签添加移入鼠标样式改变事件
  $("#topNavHL .navHL>li").on("mouseenter", function () {
    $(this).css("cursor", "pointer");
  })

  //移入三角形,上方导航栏内容颜色变化事件
  /**
   * 移入三角形,上方导航栏内容颜色变化事件函数封装
   * @param selector1 隐藏各导航栏的类名
   * @param selector2 对应的导览栏的li标签的类名
   */
  function colorChange(selector1, selector2) {
    $("#topNavHL").children(selector1).children(".tri").on("mouseenter",
        function () {
          $(this).css("cursor", "pointer");
          $("#topNavHL .navHL").children(selector2).children("a").css("color",
              "rgb(209, 192, 168)");
        });
    $("#topNavHL").children(selector1).children(".tri").on("mouseleave",
        function () {
          $("#topNavHL .navHL").children(selector2).children("a").css("color",
              "");
        })
  };

  colorChange(".daolangHL", ".daolang");
  colorChange(".zhanlangHL", ".zhanlang");
  colorChange(".jiaoyuHL", ".jiaoyu");
  colorChange(".tansuoHL", ".tansuo");
  colorChange(".xueshuHL", ".xueshu");
  colorChange(".wenchuangHL", ".wenchuang");
  colorChange(".guanyuHL", ".guanyu");
  //滚动事件

  var a = 0;
  var b = 0;
  var c = 0;
  var d = 0;
  var e = 0;
  $(window).on("scroll", function () {
    var height = $(window).scrollTop();
    //第一个轮播图的动画事件if
    if (height > 50 && height < 70 && a == 0) {
      a++;
      console.log(height);
      // $(function (){

      //$(".frame>.child:gt(0)").hide();
      //用于记录轮播索引，然后将导航图标logo和内容一一对应
      var idx = 0;
      //点击导航图标logo手动切换内容

      //1.1点击事件
      $(".periodical .nav a").click(function () {
        // clearInterval(timeID);

        $(this).addClass("now").css("background-position-x",
            "-44px").siblings().removeClass("now").css("background-position-x",
            "0px");
        idx = $(this).index();
        $(".periodical .frame>.child").eq(idx).siblings(".child").fadeOut(200);
        $(".periodical .frame>.child").eq(idx).show().children(".image").css({
          "left": -40,
          opacity: 0
        }).animate({"left": 40, opacity: 1}, 1500);
        $(".periodical .frame>.child").eq(idx).children(".text").css({
          "right": 20,
          opacity: 0
        }).animate({"right": 100, opacity: 1}, 1500);
        //-44px 对应轮播的彩色
      });
      //1.2间隔轮播
      setInterval(function () {
        if (idx > 3) {
          idx = 0;
        }
        $(".periodical .frame>.child").eq(idx).siblings(".child").fadeOut(200);
        $(".periodical .frame>.child").eq(idx).show().children(".image").css({
          "left": -40,
          opacity: 0
        }).animate({"left": 40, opacity: 1}, 1500);
        $(".periodical .frame>.child").eq(idx).children(".text").css({
          "right": 20,
          opacity: 0
        }).animate({"right": 100, opacity: 1}, 1500);

        $(".periodical .nav a").eq(idx).addClass("now").css(
            "background-position-x", "-44px").siblings().removeClass("now").css(
            "background-position-x", "0px");
        console.log($(window).scrollTop());
        idx++;
      }, 2000);

      // });

      // $(window).off("scroll");
    }

    //第二个书包轮播图的动画事件
    if (height > 480 && height < 530 && b == 0) {
      b++;
      console.log($(window).scrollTop());
      // $(function (){

      //用于记录轮播索引，然后将导航图标logo和内容一一对应
      var idx = 0;
      //点击导航图标logo手动切换内容

      $(".protects .nav a").click(function () {
        // clearInterval(timeID);

        $(this).addClass("now").css("background-position-x",
            "-44px").siblings().removeClass("now").css("background-position-x",
            "0px");
        idx = $(this).index();
        $(".protects .frame>.child").eq(idx).siblings(".child").fadeOut(200);
        $(".protects .frame>.child").eq(idx).show().children(".image").css({
          "right": 20,
          opacity: 0
        }).animate({"right": 100, opacity: 1}, 1000);
        $(".protects .frame>.child").eq(idx).show().children(".icon1").css({
          "top": -180,
          opacity: 0
        }).animate({"top": -110, opacity: 1}, 1000);
        $(".protects .frame>.child").eq(idx).children(".text").css({
          "left": -40,
          opacity: 0
        }).animate({"left": 40, opacity: 1}, 1000);
        //-44px 对应轮播的彩色

      });
      //间隔轮播
      setInterval(function () {
        if (idx > 4) {
          idx = 0;
        }
        $(".protects .frame>.child").eq(idx).siblings(".child").fadeOut(200);
        $(".protects .frame>.child").eq(idx).show().children(".image").css({
          "right": 20,
          opacity: 0
        }).animate({"right": 100, opacity: 1}, 1000);

        $(".protects .frame>.child").eq(idx).show().children(".icon1").css({
          "top": -180,
          opacity: 0
        }).animate({"top": -110, opacity: 1}, 1000);
        $(".protects .frame>.child").eq(idx).children(".text").css({
          "left": -40,
          opacity: 0
        }).animate({"left": 40, opacity: 1}, 1000);

        $(".protects .nav a").eq(idx).addClass("now").css(
            "background-position-x", "-44px").siblings().removeClass("now").css(
            "background-position-x", "0px");

        idx++;

      }, 2000);

      // });

      // $(window).off("scroll");
    }

    //第三个壁纸动画
    if (height > 1200 && height < 1240 && c == 0) {
      c++;
      $(".item3>.icon2").show().css({"top": -120, opacity: 0}).animate(
          {"top": -30, opacity: 1}, 2000);
    }

    //第四个游戏动画
    if (height > 2550 && height < 2600 && d == 0) {
      d++;
      console.log(height);
      // $(function (){

      $(".item4>.child").show().children(".img").css(
          {"right": -60, opacity: 0}).animate({
        "right": -10,
        opacity: 1
      }, 2000);
      $(".item4>.child>.text").css({"left": -60, opacity: 0}).animate(
          {"left": 0, opacity: 1}, 2000);

      // });
    }

    //第个五轮播图的动画事件
    if (height > 2300 && height < 2350 && e == 0) {
      e++;
      console.log($(window).scrollTop());

      //用于记录轮播索引，然后将导航图标logo和内容一一对应
      var idx = 0;
      //点击导航图标logo手动切换内容
      setInterval(function () {
        if (idx > 10) {
          idx = 0;

        }
        $(".imgtextwarp>.w1").eq(idx).siblings(".w1").fadeOut(200);
        $(".imgtextwarp>.w1").eq(idx).show().children(".imglist").css({
          "top": 0,
          opacity: 0
        }).animate({"top": 35, opacity: 1}, 1000)

        $(".imgtextwarp>.w1").eq(idx).show().children(".text").css({
          "right": -70,
          opacity: 0
        }).animate({"right": 10, opacity: 1}, 1000)

        if (flag && idx < 10) {

          flag = false;
          pos.push(pos.shift());
          // 数组现在是重新排列的了，再让li标签根据新的数组，重新生成自己的样式
          assign();
        }

        idx++;

      }, 2000)
    }

  })

  var pos = [
    {
      left: 104.016,
      top: 381.232
    },
    {
      left: -5.98374,
      top: 301.313
    },
    {
      left: -48,
      top: 172
    },
    {
      left: -5.98374,
      top: 42.6872
    },
    {
      left: 104.016,
      top: -37.2324
    },
    {
      left: 239.984,
      top: -37.2324
    },
    {
      left: 349.984,
      top: 42.6872
    },
    {
      left: 392,
      top: 172
    },
    {
      left: 349.984,
      top: 301.313,

    },
    {
      left: 239.984,
      top: 381.232
    }];
  var imgs = $(".arc .arcbox .img");
  // var buttons=$(".arc .arcbox .button1");
  var flag = true;
// 2. 让每个div img标签走到指定的位置
  assign();

  function assign() {
    $.each(pos, function (index, ele) {
      // index是索引号  ele是数组中的对象
      imgs.eq(index).stop().animate(ele, 500, function () {
        flag = true;
      });
      imgs.eq(index).stop().animate(ele, 500, function () {
        flag = true;
      });
    });
  }

  // 4. 给右侧按钮注册事件
  $(".prev").on("click", function () {
    if (flag) {
      flag = false;
      pos.unshift(pos.pop());

      assign();
    }
  })
  // 5. 给左侧按钮注册事件
  $(".next").on("click", function () {
    if (flag) {
      flag = false;
      pos.push(pos.shift());
      // 数组现在是重新排列的了，再让li标签根据新的数组，重新生成自己的样式
      assign();
    }

  })
  //qrCode显示事件
  $("#footer .qrCode a").on("mouseenter", function () {
    $("#footer .qrCodeImg").show();
  });
  $("#footer .qrCode a").on("mouseleave", function () {
    $("#footer .qrCodeImg").hide();
  });

  //qr小手自动来回移动
  setInterval(function () {
    $("#footer .qrCode .hand").animate({
      "top": "31px",
      "left": "33px"
    }, 300, 'swing', function () {
      $("#footer .qrCode .hand").animate({
        "top": "25px",
        "left": "22px"
      }, 300, 'swing', function () {
        $("#footer .qrCode .hand").animate({
          "top": "31px",
          "left": "33px"
        }, 300, 'swing', function () {
          $("#footer .qrCode .hand").animate({
            "top": "25px",
            "left": "22px"
          }, 300)
        })
      })
    })
  }, 3000)

})



