// JavaScript Document

//全局js
$(function () {
  //start
  $('.header .nav_child .child p:last-child').addClass('last');

  $('.body').css('min-height', $(window).height() - 94 - 195);
  $('#header .nav_child .child p:last-child').addClass('last');
  $(window).resize(function () {
    $('.body').css('min-height', $(window).height() - 94 -
        195);
  });

  $(".header .scbtn").bind('click', function (e) {
    e.stopPropagation();
    $(".scbtn .search").fadeToggle(200);
  });

  $(".header .lang").hover(function () {
    $('.header .language').fadeIn(200);
  });

  $(".header .login").hover(function () {
    $('.header .loginbox').fadeIn(200);
  });

  /*  $(".header .scbtn").mouseleave(function() {
        $(".scbtn .search").fadeOut(200);
    });*/
  $('.header .search').bind('click', function (e) {
    e.stopPropagation();
  });
  $(window).bind('click', function () {
    $('.header .search').hide();
  });
  $(".header .lang").mouseleave(function () {
    $('.header .language').fadeOut(200);
  });

  $(".header .login").mouseleave(function () {
    $('.header .loginbox').fadeOut(200);
  });
  $('.close, .overlay').on('click', function () {
    $(this).parents('.popWindow').fadeOut(100);
  });
  //滚动条
  /*$("html").niceScroll({
    cursorcolor:"#111",
    cursorborder:"none",
    cursorwidth:"8px",
    scrollspeed:80,
    background:"#aaa",
    cursoropacitymin:0,
    cursoropacitymax:0.7,
    enablekeyboard:false,
    zindex:2
  });*/

  var sto_nav;
  //导航
  $(".nav_main li").hover(
      function () {
        clearTimeout(sto_nav);
        $(".nav_main li").removeClass("cur");
        $(".nav_child .child").removeClass("now");
        var child = $(".nav_child .child").eq($(this).index());
        if (child.children().size() > 0) {
          $(this).addClass("cur");
          $(".nav_child .child").stop(true, true).eq($(this).index())
          .addClass("now");
          child.find('.p').css({
            marginLeft: ($(this).offset().left + ($(
                this).width() / 2)) - (child.find(
                '.p').width() / 2)
          });
          console.log(($(this).offset().left + ($(this).width() /
              2)) - (child.find('.p').width() / 2));
        }
      },
      function () {
        console.log(1);
        sto_nav = setTimeout(function () {
          $(".nav_main li").removeClass("cur");
          $(".nav_child .child").removeClass("now");
        }, 200);
      }
  );
  $(".nav_child .child").hover(
      function () {
        clearTimeout(sto_nav);
        $(this).addClass("now");
      },
      function () {
        $(this).removeClass("now");
        $(".nav_main li").removeClass("cur");
      }
  );

  $(".filter .select").hover(
      function () {
        $(this).find("ul").show();
      },
      function () {
        $(this).find("ul").hide();
      }
  );
  $(".filter .select li").click(function () {
    $(this).parents(".select").find("input").val($(this).text());
    $(this).parent().hide();
  });

  //placeholder
  if ('placeholder' in document.createElement('input') == false) {
    $("input,textarea").each(function (index, element) {
      if ($(this).attr("placeholder") != undefined) {
        if ($(this).attr("type") != "password") {
          $(this).val($(this).attr("placeholder"));
          $(this).attr("onFocus", "if(this.value=='" +
              $(this).attr("placeholder") +
              "')this.value=''");
          $(this).attr("onBlur",
              "if(this.value=='')this.value='" +
              $(this).attr("placeholder") + "'");
        }
      }
    });
  }
  $(".passwd").each(function (index, element) {
    var t = $(this);
    if ('placeholder' in document.createElement('input') ==
        false) {
      $(this).find(".b").focus(function () {
        $(this).hide();
        t.find(".a").focus();
      });
      $(this).find(".a").focus(function () {
        t.find(".b").hide();
      });
      $(this).find(".a").blur(function () {
        if ($(this).val() == "") {
          t.find(".b").show();
        }
      });
    } else {
      t.find(".a").attr("placeholder", t.find(".b").attr(
          "placeholder"));
      t.find(".b").remove();
    }
  });

  //底部
  if ($(".header").height() + $(".body").height() + $(".footer").height() <
      $("body").height()) {
    $(".footer").addClass("fb");
  } else {
    $(".footer").removeClass("fb");
  }
  $(window).resize(function () {
    if ($(".header").height() + $(".body").height() + $(
        ".footer").height() < $("body").height()) {
      $(".footer").addClass("fb");
    } else {
      $(".footer").removeClass("fb");
    }
  });

  // $(".checkbox").click(function(){
  // 	$(this).toggleClass("ckd");
  // });

  $(document).on('click', '.checkbox', function () {
    $(this).toggleClass("ckd");
  });

  /*$(".gotop").click(function(){
    $("html").animate({scrollTop:0},400+$(window).scrollTop()*0.3);
    if(navigator.appVersion.match("WebKit")){
      $("body").animate({scrollTop:0},400+$(window).scrollTop()*0.3);
    }
    else{
      $("html").animate({scrollTop:0},400+$(window).scrollTop()*0.3);
    }
  });
  $(window).scroll(function(){
    if($(window).scrollTop()>100){$(".gotop").fadeIn();}
    else{$(".gotop").fadeOut();}
  });*/

  //浏览建议 start
  $("#footer .jy").bind("click", function () {
    $("#footer .proposal").animate({
      bottom: 0,
    });
    return false;
  });

  $("#footer .proposal").bind("mouseout", function (e) {
    $(this).animate({
      bottom: '-60px',
    });
  });
  //浏览建议	end
  //end
});

//新tab切换
function tabdiv(tab, div, event, speed) {
  speed = isNaN(speed) ? 0 : speed;
  $(div).each(function (index, element) {
    $(this).attr("idx", index);
  });
  $(tab).each(function (index, element) {
    $(this).bind(event, function () {
      $(tab).removeClass("now");
      $(this).addClass("now");
      $(div + "[idx!='" + index + "']").hide();
      $(div + "[idx='" + index + "']").fadeIn(speed,
          function () {
            //fn();
          });
    });
  });
}

//	打开弹窗
function openAlert(ele) {
  $(ele).fadeIn(300);
};

//	关闭弹窗
function closeAlert() {
  $('.popWindow').fadeOut(300);
};
$(function () {
  $(document).on("click", ".select-box dt a", function (e) {
    e.preventDefault();
    e.stopPropagation();
    $(this).parent().toggleClass("open");
    $(this).parents(".sc_com").toggleClass("ieopen");
    $(this).parent().parent(".select-box").find("dd").toggle();
  })
  $(document).on("click", ".select-box dd a", function (e) {
    $(this).addClass("on").siblings().removeClass("on");
    $(this).parents(".select-box").find("dt b").html($(this).html());
    $(".select-box dt").toggleClass("open");
    $(".select-box dd").hide();
    var _val = $(this).data("val")
    $(this).closest(".select-box").find("dt input").val(_val)
  })
  $(document).click(function () {
    $(".select-box dt").removeClass("open");
    $(".select-box dd").hide();
    $(".sc_com").removeClass("ieopen");
  })

})

function scorllAnimate(ele) {
  var _offsetAnimate = $(ele).offset().top
  var _scroll1Animate = $(window).scrollTop() + $(window).height() / 1.5;
  if (_scroll1Animate >= _offsetAnimate) {
    $(ele).addClass("animate")
  } else {
    $(ele).removeClass("animate")
  }
}
