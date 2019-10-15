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

  //教育新闻版块
  $("#newsHL>.w>div").on("mouseenter", function () {
    //底边框变粗
    $(this).find(".date").animate({
      "border-bottom-width": "4px",
    });
    $(this).find(".date").css("border-bottom-color", "rgb(153, 124, 82)");
    //背景图片放大
    $(this).find(".photo").animate({
      "background-size": "115%"
    }, 1000);

  });

  $("#newsHL>.w>div").on("mouseleave", function () {
    //底边框恢复
    $(this).find(".date").animate({
      "border-bottom-width": "2px",
    });
    $(this).find(".date").css("border-bottom-color", "");
    //背景图片恢复大小
    $(this).find(".photo").animate({
      "background-size": "100%"
    }, 1000);

  });

  //轮播图自动翻页
  var index = 0;

  setInterval(nextPage, 3000);

  $('.btnRight').on("click", function () {
    nextPage();
  });

  $('.btnLeft').on("click", function () {
    if (index == 0) {
      index = 2;
      $("#lunbotuHL").css("left", -1350 * index + "px");
    }
    ;
    index--;
    $("#lunbotuHL").animate({
      "left": -1350 * index + "px"
    }, 500);

  });

  /**
   * 向后一页缓动移动的封装函数
   */
  function nextPage() {
    if (index == 2) {
      index = 0;
      $("#lunbotuHL").css("left", 0);
    }
    ;
    index++;
    $("#lunbotuHL").animate({
      "left": -1350 * index + "px"
    }, 500);
  }

  //设置页面下拉自定义动画
  $(window).on("scroll", function () {

    if ($(this).scrollTop() > 1400 && $(this).scrollTop() < 1450) {
      console.log("1");
      $(".vase").animate({
        "left": "165px",
        "opacity": 1
      }, 1300);
    }
    if ($(this).scrollTop() > 2040 && $(this).scrollTop() < 2080) {
      console.log("2");
      $(".box").animate({
        "left": "110px",
        "opacity": 1
      }, 1300);
    }
    if ($(this).scrollTop() > 2500 && $(this).scrollTop() < 2540) {
      //用.fadeIn()做不出来效果
      // console.log("3");
      $(".ding").fadeIn(1000);
      $(".ding").animate({
        "opacity": 1
      }, 2500);
    }
    if ($(this).scrollTop() > 3015 && $(this).scrollTop() < 3050) {
      console.log("4");
      $("#kidStoreHL .girlPic").animate({
        "left": 0,
        "opacity": 1
      }, 1300);
    }
  });

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

});
