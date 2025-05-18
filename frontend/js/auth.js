const isAuthenticated = () => {
    return localStorage.getItem('token') !== null;
};

const getAuthHeader = () => {
    const token = localStorage.getItem('token');
    return token ? { 'Authorization': `Bearer ${token}` } : {};
};

const updateNavbarIcon = () => {
    const userNav = document.querySelector('.navbar-item:last-child');
    if (isAuthenticated()) {
        userNav.innerHTML = `
            <a class="navbar-link" href="#" onclick="logout()">
                <i class="fa fa-sign-out" aria-hidden="true"></i> 
            </a>`;
    } else {
        userNav.innerHTML = `
            <a class="navbar-link" href="login.html">
                <i class="fa-regular fa-user"></i>
            </a>`;
    }
};

const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('userId');
    updateNavbarIcon();
    window.location.href = 'login.html';
};