package com.tp2.web;

import com.tp2.Repositories.PatientRepository;
import com.tp2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository ;

    @GetMapping( path = "/index" )
    public String listPatient(Model model, @RequestParam(name = "name",defaultValue = "")String name ,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue = "2")int size){
        Page<Patient> pagePatient = patientRepository.findByNomContains(name , PageRequest.of(page, size));
        model.addAttribute("listPatient",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("name",name);
        model.addAttribute("size",size);
        return "patientView";
    }
    @GetMapping(path = "deletePatient")
    public String delete(Long id , String name , int page ,int size){
        patientRepository.deleteById(id);

        return "redirect:/index?page="+page+"&size="+size+"&name="+name;
    }

    @GetMapping(path = "/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }

    @PostMapping( path = "/savePatient")
    public String savPatient(@Valid Patient patient , BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return  "formPatient";
        patientRepository.save(patient);
        return "redirect:/index" ;
    }
    @GetMapping(path = "/editPatient")
    public String editPatient(Model model , Long id ){
        Patient p = patientRepository.findById(id).get();
        model.addAttribute("patient",p);
        return "formPatient";
    }
}
