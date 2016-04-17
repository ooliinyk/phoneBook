package com.controller;

import com.entity.PhoneBookItem;
import com.entity.Role;
import com.entity.User;
import com.service.PhoneBookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by user on 16.04.2016.
 */

@Controller
public class PhoneBookItemController {

    @Autowired
    PhoneBookItemService phoneBookItemService;

    @RequestMapping(value = {"/listAdmin"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        PhoneBookItem phoneBookItem = new PhoneBookItem();
        List<PhoneBookItem> phoneBookItems = phoneBookItemService.findAll();
        model.addAttribute("phoneBookItems", phoneBookItems);
        model.addAttribute("phoneBookItem", phoneBookItem);
        return "main";
    }


    @RequestMapping(value = "/addPhoneBookItem", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        PhoneBookItem phoneBookItem = new PhoneBookItem();
        model.addAttribute("phoneBookItem", phoneBookItem);
        return "addItem";
    }


    @RequestMapping(value = "/addPhoneBookItem", method = RequestMethod.POST)
    public String savedRegistration(@Valid PhoneBookItem phoneBookItem,
                                    BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "registration";
        }

     phoneBookItemService.saveDocument(phoneBookItem);
//        return "redirect:/login";
        return "welcome";
    }


    /**
     * ці методи використовується для редагування даних книги
     */
    @RequestMapping(value = {"/edit-phoneBook-{phoneBookItemId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable Long phoneBookItemId, ModelMap model) {
        PhoneBookItem phoneBookItem=phoneBookItemService.findById(phoneBookItemId);

        model.addAttribute("phoneBookItem", phoneBookItem);
        model.addAttribute("edit", true);
        return "addItem";
    }

    @RequestMapping(value = {"/edit-phoneBook-{phoneBookItemId}"}, method = RequestMethod.POST)
    public String updateBook(@Valid PhoneBookItem phoneBookItem, BindingResult result,
                            ModelMap model, @PathVariable Integer phoneBookItemId) {

        if (result.hasErrors()) {
            return "addItem";
        }

        phoneBookItemService.updatePhoneBookItem(phoneBookItem);


        return "redirect:/listAdmin";
    }


    /**
     * Цей метод видаляє книгу по ід
     */
    @RequestMapping(value = {"/delete-phoneBook-{phoneBookItemId}"}, method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long phoneBookItemId) {
        phoneBookItemService.deleteById(phoneBookItemId);
        return "redirect:/listAdmin";
    }

}
