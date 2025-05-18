document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('registration-form');
    const errorDiv = document.createElement('div');
    errorDiv.className = 'error-message';
    form.insertBefore(errorDiv, form.firstChild);

    form.addEventListener('submit', async function(e) {
        e.preventDefault();
        errorDiv.textContent = ''; // Clear previous errors
        
        // Check terms and conditions
        const termsAccepted = document.getElementById('terms-conditions').checked;
        if (!termsAccepted) {
            errorDiv.textContent = 'Prosím, přijměte podmínky použití';
            return;
        }

        const formData = {
            username: document.getElementById('username').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password').value
        };

        try {
            const response = await fetch('http://localhost:8080/api/auth/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData)
            });

            const data = await response.json();

            if (response.ok) {
                // Show success message and redirect
                alert('Registrace proběhla úspěšně!');
                window.location.href = 'login.html';
            } else {
                // Display error message from server
                errorDiv.textContent = data.message || 'Registrace se nezdařila. Zkuste to prosím znovu.';
            }
        } catch (error) {
            console.error('Error:', error);
            errorDiv.textContent = 'Došlo k chybě při komunikaci se serverem. Zkuste to prosím později.';
        }
    });
});