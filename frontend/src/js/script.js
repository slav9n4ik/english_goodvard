const menuButton = document.querySelector('.open-nav');
const nav = document.querySelector('.nav');

menuButton.addEventListener("click", () => {
    if (nav.classList.contains('navigation-open')) {
        nav.classList.remove('navigation-open');
    } else {
        nav.classList.add('navigation-open');
    }
});

// Courses
if (window.screen.width <= 700) {
  var swiper = new Swiper('.swiper-container', {
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    }
  });
} else {
  let swiperWrapper = $(".swiper-wrapper")[0];
  swiperWrapper.className = swiperWrapper.className.replace("swiper-wrapper", "swiper-wrapper-desktop");
  let activeMainContents = $(".course-item-active");
  let swiperSlides = $(".swiper-slide");
  let coursesRow = $(".courses-row");
  $(".course-item-active").detach();
  $(".swiper-slide").detach();
  $(".courses-row").detach();

  //stupid hardcode
  swiperWrapper.append(coursesRow[0]);
  swiperWrapper.append(activeMainContents[0]);
  swiperWrapper.append(activeMainContents[1]);
  swiperWrapper.append(coursesRow[1]);
  swiperWrapper.append(activeMainContents[2]);
  swiperWrapper.append(activeMainContents[3]);


  coursesRow[0].append(swiperSlides[0]);
  coursesRow[0].append(swiperSlides[1]);
  coursesRow[1].append(swiperSlides[2]);
  coursesRow[1].append(swiperSlides[3]);

}

var arrows = $(".more-course-info-btn");
var activeItems = $(".course-item-active");
var items = $(".course-item");
var activeImages = $(".active-img");
var offsetHeightItem = items[0].offsetHeight;

// Course desktop more info
function showMoreInfo(itemIndex) {
  if (window.screen.width > 700) {
    for (let i = 0; i < items.length; i++) {
      if (i === itemIndex) {
          items[i].className.includes("course-active") ? 
            closeCourseBlock(i, offsetHeightItem) : showCourseBlock(i, offsetHeightItem)
      } else {
        closeCourseBlock(i, offsetHeightItem);
      } 
    }
  }
 }

function showCourseBlock(i, offsetHeight) {
    items[i].className += " course-active";
    items[i].style.height = offsetHeight * 1.15 + 'px';
    activeItems[i].style.display = 'flex';
    activeImages[i].style.display = 'flex';
    activeItems[i].style.marginTop = offsetHeight * -0.1  + 'px';
    arrows[i].style.display = 'none';
 }

function closeCourseBlock(i, offsetHeight) {
    items[i].className = items[i].className.replace(" course-active", "");
    items[i].style.height = offsetHeight + "px";
    activeItems[i].style.display = 'none';
    activeImages[i].style.display = 'none';
    arrows[i].style.display = 'block';
}