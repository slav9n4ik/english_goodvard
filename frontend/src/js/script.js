const menuButton = document.querySelector('.open-nav');
const nav = document.querySelector('.nav');

menuButton.addEventListener("click", () => {
    if (nav.classList.contains('navigation-open')) {
        nav.classList.remove('navigation-open');
    } else {
        nav.classList.add('navigation-open');
    }
});

/* Course Carousel */
var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

// mobile course slider
function showSlides(n) {  
  if (window.screen.width <= 700) {
    let containers = document.getElementsByClassName("courses-container");
    let slides = document.getElementsByClassName("course-item");
    let activeSlides = document.getElementsByClassName("course-item-active");
    let dots = document.getElementsByClassName("dot");

    if (n > slides.length) {slideIndex = 1; n = 1;}
    if (n < 1) {slideIndex = slides.length; n = slides.length;}

    if (slideIndex === 1 || slideIndex === 2) {
      containers[0].style.display = "flex";
      containers[1].style.display = "none";
    } else {
      containers[1].style.display = "flex";
      containers[0].style.display = "none";
    }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
        activeSlides[i].style.display = "none";
    }

    for (let i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[n - 1].style.display = "flex";
    activeSlides[n - 1].style.display = "flex";
    dots[n - 1].className += " active";
  } 
}

var arrows = document.getElementsByClassName("more-course-info-btn");
var activeItems = document.getElementsByClassName("course-item-active");
var items = document.getElementsByClassName("course-item");
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
    items[i].style.height = offsetHeight * 1.1 + 'px';
    activeItems[i].style.display = 'flex';
    activeItems[i].style.marginTop = offsetHeight * -0.05  + 'px';
    arrows[i].style.display = 'none';
 }

function closeCourseBlock(i, offsetHeight) {
    items[i].className = items[i].className.replace(" course-active", "");
    items[i].style.height = offsetHeight + "px";
    activeItems[i].style.display = 'none';
    arrows[i].style.display = 'block';
}