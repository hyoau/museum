$(function () {

//ie6
  if ($.browser.msie) {
    if (parseInt($.browser.version) < 9) {
      $("body").prepend(
          "<div class='ie6' style='display:none;height:" + $(window).height()
          + "px'><span>关闭</span><a href='http://browsehappy.com/' target='_blank' style='text-decoration:underline'></a></div>");
      $(".ie6").animate({height: "toggle", opacity: "toggle"}, 1000);
      $(".ie6 span").click(function () {
        $(".ie6").slideUp()
      });
    }
  }

//顶部导航菜单
  var vNavWaitSlide, NavWaitSlide;
  $('#nav > li').hover(
      function () {
        $(this).find('a:first').addClass("hover");
        var current_li = $(this), targ = $(current_li).find('ul:first');
        NavWaitSlide = setTimeout(function () {
          if (!$(targ).is(':visible')) {
            $(targ).css({
              left: 0 - ($(targ).width() / 2) + (current_li.outerWidth() / 2),
              top: 0 + $(current_li).outerHeight()
            })
            $(targ).fadeIn('fast');
          }
        }, 100)
      },
      function () {
        clearTimeout(NavWaitSlide);
        $(this).find('ul').hide();
        $(this).find('a:first').removeClass("hover");
      }
  );

  $(".bell").click(function () {
    $(".masklayer").show();
    $(".pop").fadeIn("false");
    $(".pop .popcontent").jScrollPane();
    $(".masklayer").one("click", function () {
      $(".pop").hide();
      $(".masklayer").hide()
    })

  })

  $(".newslayer a.close").click(function () {
    $(".newslayer").fadeOut("false");
    $(".masklayer").hide();
  })

  $(".pop a.close").click(function () {
    $(".pop").fadeOut("false");
    $(".masklayer").hide();
  })

  $(".footer .relink").hover(function () {
        $(this).find("ul").show();
      },
      function () {
        $(this).find("ul").hide();
      }
  );
  $(".header nav .search").click(
      function () {
        $(".header .searchwraper").slideToggle("fast");
        return false;
      }
  )
  $(document).scroll(function () {
    if ($(document).scrollTop() >= 350) {
      $('#resultnav').css({"position": "fixed", "top": "0"});
    } else {
      $('#resultnav').css({"position": "absolute", "top": "350px"});
    }
  })

  //分享返回顶部
  $(window).scroll(function () {
    if ($(window).scrollTop() >= 400) {
      $("#rightscrollnav .returntop").fadeIn("fast");

    } else {
      $("#rightscrollnav .returntop").fadeOut("fast");
    }
  })

  $("#rightscrollnav .returntop").click(function () {
    $("html,body").animate({scrollTop: 0}, 500);
  });

  //$("#rightscrollnav .focusus").click(function(){$("#rightscrollnav li.focusus div").toggle();})

  $('body').bind("click", function (e) {
    var target = $(e.target);
    if (target.is('#rightscrollnav .focusus')) {
      $("#rightscrollnav li.focusus div").toggle();
      return;
    }
    if (target.closest("#rightscrollnav li.focusus div").length == 0) {
      $("#rightscrollnav li.focusus div").hide();
    }
  })

  $("#rightscrollnav .share").click(function () {
    bShare.more();
  })
  //分享返回顶部
  //mobile nav
  $(".mobilenav .menu").click(function () {
    if ($(".mobilenav").is(".active")) {
      $(".mobilenav, .mobile .header nav  ul").removeClass("active");
      $(".menumask").fadeOut("fast");
    } else {

      $(".mobilenav,.mobile .header nav  ul").addClass("active");
      $(".menumask").fadeIn("fast");

    }
  })

  $(".menumask").click(function () {
    $(".mobilenav, .mobile .header nav  ul").removeClass("active");
    $(".menumask").fadeOut("fast");
  });
})
