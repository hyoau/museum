$(function () {

  //����һ������,������¼��ǰ��ʾͼƬ������.
  var index = 0;
  //����1:����ұ߽���,��һ��li������ʾfadeIn,������li��������fadeOut
  $('.wenwu .tupin .arrow-right').on('click', function () {
    index++;
    //��������������һ��ͼƬ(������7), ��ô����ұ߽���index����8, ����Ҫ��ʾ��һ�ž�Ӧ�ð�index���0.
    if (index == 2) { //8��ò�Ҫд��,���ֲ�ͼͼƬ�ĸ���.
      index = 0;
    }
    console.log(index);
    $('.wenwu .tupin li').eq(index).fadeIn(500).siblings('li').fadeOut(500);
  });

  //����2:�����߽���,��һ��li������ʾfadeIn,������li��������fadeOut
  $('.wenwu .tupin .arrow-left').on('click', function () {
    index--;
    //����������ǵ�һ��,�����߽���index���-1, ��������Ҫ��ʾ���һ��,Ӧ��index�ĳ�7.
    if (index == -1) {
      index = 1; //7Ҳ��Ҫд��,Ӧ�����ֲ�ͼͼƬ�ĸ���-1
    }
    console.log(index);
    $('.wenwu .tupin li').eq(index).fadeIn(500).siblings('li').fadeOut(500);
  });

});

