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
  $("#search input").blur(function () {
    var search = $("#search")[0];
    setTimeout(function () {
      search.style.display = "none";
    }, 2000);
  })

});


