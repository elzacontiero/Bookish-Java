package org.softwire.training.bookish.controllers;
import org.softwire.training.bookish.models.page.CopiesModel;
import org.softwire.training.bookish.services.CopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.softwire.training.bookish.models.database.Copies;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/copies")
public class CopiesController {

    private final CopiesService copiesService;

    @Autowired
    public CopiesController(CopiesService copiesService) {
        this.copiesService = copiesService;
    }

    @RequestMapping("")
    ModelAndView allCopies() {

        List<Copies> allCopies = copiesService.getAllCopies();

        CopiesModel acm = new CopiesModel();
        acm.setCopies(allCopies);

        return new ModelAndView("copies", "acm", acm);
    }

    @RequestMapping("/add-copy")
    RedirectView addCopies(@ModelAttribute Copies copy) {

        copiesService.addCopy(copy);

        return new RedirectView("/copies");
    }

    @RequestMapping("/delete-copy")
    RedirectView deleteCopy(@RequestParam int copyId) {

        copiesService.deleteCopies(copyId);

        return new RedirectView("/copies");
    }

}


