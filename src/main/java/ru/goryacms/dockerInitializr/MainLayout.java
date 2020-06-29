package ru.goryacms.dockerInitializr;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import ru.goryacms.dockerInitializr.views.initializr.DockerInitializrView;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {
    public MainLayout() {
        createHeader();
        createRight();
        createDrawer();
    }

    private void createRight() {
        Button dark = new Button(new Icon(VaadinIcon.MOON_O));
        dark.setClassName("dark");
        Button light = new Button(new Icon(VaadinIcon.SUN_O));
        light.setClassName("light");
        dark.setDisableOnClick(true);
        light.setDisableOnClick(true);

        dark.addClickListener(event -> switchTheme(dark, light));
        light.addClickListener(event -> switchTheme(dark, light));

        VerticalLayout right = new VerticalLayout(new Div(dark, light));

        right.setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.END);
        right.addClassName("right");

        addToNavbar(right);
    }

    private void createHeader() {
        H1 logo = new H1("Docker starter");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

        header.setDefaultVerticalComponentAlignment(
                FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Docker Initializr", DockerInitializrView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        Paragraph paragraph = new Paragraph("\u00A9 2020 gorjachev_maksim@mail.ru \n" +
                " docker initializer is powered by Goryachev Maksim, Russia Penza");

        VerticalLayout verticalLayout = new VerticalLayout(listLink, paragraph);
        verticalLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        verticalLayout.setWidth("100%");
        addToDrawer(verticalLayout);
    }

    private void switchTheme(Button dark, Button light) {
        ThemeList themeList = UI.getCurrent().getElement().getThemeList();
        String className = dark.getClassName();
        if ("dark".equals(className)) {
            themeList.remove(Lumo.LIGHT);
            themeList.add(Lumo.DARK);

            dark.setClassName("white");
            light.setClassName("dark");

            light.setEnabled(true);
            dark.setEnabled(false);
        } else {
            themeList.remove(Lumo.DARK);
            themeList.add(Lumo.LIGHT);

            dark.setClassName("dark");
            light.setClassName("white");

            dark.setEnabled(true);
            light.setEnabled(false);
        }
    }
}