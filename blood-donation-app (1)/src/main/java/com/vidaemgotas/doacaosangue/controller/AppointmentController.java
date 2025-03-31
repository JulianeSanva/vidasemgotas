package com.vidaemgotas.doacaosangue.controller;

import com.vidaemgotas.doacaosangue.model.Appointment;
import com.vidaemgotas.doacaosangue.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/agendamento")
    public String createAppointment(@ModelAttribute Appointment appointment, 
                                   RedirectAttributes redirectAttributes) {
        try {
            appointmentService.saveAppointment(appointment);
            redirectAttributes.addFlashAttribute("successMessage", 
                "Agendamento realizado com sucesso! Em breve entraremos em contato para confirmar.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", 
                "Erro ao realizar agendamento. Por favor, tente novamente.");
        }
        
        return "redirect:/";
    }
}

