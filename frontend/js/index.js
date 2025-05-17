// navbar-menu
const navbarToggle = navbar.querySelector("#navbar-toggle");
const navbarMenu = document.querySelector("#navbar-menu");
const navbarLinksContainer = navbarMenu.querySelector(".navbar-links");
let isNavbarExpanded = navbarToggle.getAttribute("aria-expanded") === "true";

const toggleNavbarVisibility = () => {
  isNavbarExpanded = !isNavbarExpanded;
  navbarToggle.setAttribute("aria-expanded", isNavbarExpanded);
};

navbarToggle.addEventListener("click", toggleNavbarVisibility);

navbarLinksContainer.addEventListener("click", (e) => e.stopPropagation());
navbarMenu.addEventListener("click", toggleNavbarVisibility);

// race selector
const showRaces = () => {
  document.querySelectorAll('.races').forEach(el => el.classList.remove('active'));

  const selectedDate = document.getElementById('date').value;

  if (selectedDate) {
      document.getElementById(selectedDate).classList.add('active');
      showConfirmButton(true);
  } else {
      showConfirmButton(false);
  }
}

const saveSeats = (selectElement)  => {
  selectElement.setAttribute('value', selectElement.value);
}

const showConfirmButton = (show) => {
  const button = document.getElementById('submit-ride-button');
  button.style.display = show ? 'block' : 'none';
}

const confirmSelection = () => {
  alert("Vaše volba byla potvrzena!");
}

document.addEventListener('DOMContentLoaded', function() {
    updateNavbarIcon(); // Replace the existing navbar update code with this line
});