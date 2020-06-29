package ru.goryacms.dockerInitializr.views.initializr;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import ru.goryacms.dockerInitializr.dto.ServicesDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DependencyForm extends FormLayout {
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
//    ComboBox<Contact.Status> status = new ComboBox<>("Status");
//    ComboBox<Company> company = new ComboBox<>("Company");

    MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
    List<ServicesDto> servicesList;


    Button save = new Button("Save");
//    Button delete = new Button("Delete");
//    Button close = new Button("Cancel");

    public DependencyForm(Dialog dialog, List<ServicesDto> names) {
        this.servicesList = names;

        addClassName("contact-form");

        listBox.setItems(
                servicesList.stream()
                        .map(ServicesDto::getName)
                        .collect(Collectors.toList())
        );

        add(listBox,
//                firstName,
//                lastName,
//                email,
//                company,
//                status,
                createButtonsLayout(dialog));
    }

    public List<ServicesDto> getCheckedDependencies() {
        HashSet<String> filters = new HashSet<>(listBox.getSelectedItems());
        return servicesList.stream()
                .filter(it -> filters.contains(it.getName()))
                .collect(Collectors.toList());
    }

    private HorizontalLayout createButtonsLayout(Dialog dialog) {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
//        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addClickShortcut(Key.ENTER);

        save.addClickListener(event -> {
            Set<String> selectedItems = listBox.getSelectedItems();
            int size = selectedItems.size();
            Notification.show("size = " + size);
            dialog.close();
        });
//        close.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(save/*, delete, close*/);
    }
}