//package ru.goryacms.dockerInitializr.views;
//
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.dependency.JsModule;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.router.RouteAlias;
//import com.vaadin.flow.server.PWA;
//import ru.goryacms.dockerInitializr.views.main.MainView;
//
///**
// * The main view contains a text field to get the user name and a button
// * that shows a greeting message in a notification.
// */
//@Route(value = "helloworld", layout = MainView.class)
//@RouteAlias(value = "helloworld", layout = MainView.class)
//@PageTitle("Hello, world!")
////@JsModule("./styles/shared-styles.js")
////@Route("")
////@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
////@CssImport("./styles/shared-styles.css")
////@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
//public class HelloWorld extends VerticalLayout {
//
//    public HelloWorld() {
//        // Use TextField for standard text input
//        TextField textField = new TextField("Your name");
//
//        // Button click listeners can be defined as lambda expressions
////        GreetService greetService = new GreetService();
//        Button button = new Button("Say hello",
//                e -> Notification.show(textField.getValue()));
//
//        // Theme variants give you predefined extra styles for components.
//        // Example: Primary button is more prominent look.
//        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//
//        // You can specify keyboard shortcuts for buttons.
//        // Example: Pressing enter in this view clicks the Button.
//        button.addClickShortcut(Key.ENTER);
//
//        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
//        addClassName("centered-content");
//
//        add(textField, button);
//    }
//}