document.addEventListener("DOMContentLoaded", () => {
  // Form validation
  const appointmentForm = document.getElementById("appointmentForm")

  if (appointmentForm) {
    appointmentForm.addEventListener("submit", (event) => {
      const name = document.getElementById("name").value
      const email = document.getElementById("email").value
      const phone = document.getElementById("phone").value
      const date = document.getElementById("date").value
      const time = document.getElementById("time").value
      const location = document.getElementById("location").value

      let isValid = true
      let errorMessage = ""

      // Basic validation
      if (!name || !email || !phone || !date || !time || !location) {
        isValid = false
        errorMessage = "Por favor, preencha todos os campos obrigatórios."
      }

      // Email validation
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
      if (email && !emailRegex.test(email)) {
        isValid = false
        errorMessage = "Por favor, insira um e-mail válido."
      }

      // Phone validation
      const phoneRegex = /^\d{10,11}$/
      if (phone && !phoneRegex.test(phone.replace(/\D/g, ""))) {
        isValid = false
        errorMessage = "Por favor, insira um número de telefone válido (10 ou 11 dígitos)."
      }

      // Date validation - must be in the future
      const selectedDate = new Date(date)
      const today = new Date()
      today.setHours(0, 0, 0, 0)

      if (selectedDate < today) {
        isValid = false
        errorMessage = "A data de agendamento deve ser futura."
      }

      if (!isValid) {
        event.preventDefault()
        alert(errorMessage)
      }
    })
  }

  // Phone mask
  const phoneInput = document.getElementById("phone")
  if (phoneInput) {
    phoneInput.addEventListener("input", (e) => {
      let value = e.target.value.replace(/\D/g, "")

      if (value.length > 0) {
        // Format as (XX) XXXXX-XXXX or (XX) XXXX-XXXX
        if (value.length <= 10) {
          value = value.replace(/^(\d{2})(\d{4})(\d{0,4})/, "($1) $2-$3")
        } else {
          value = value.replace(/^(\d{2})( {2}'($1) $2-$3');
        }
        else
        value = value.replace(/^(\d{2})(\d{5})(\d{0,4})/, "($1) $2-$3")
      }

      e.target.value = value
    })
  }
})

