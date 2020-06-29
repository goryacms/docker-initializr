//package ru.goryacms.dockerInitializr.views.main;
//
////import com.example.application.views.dashboard.DashboardView;
////import com.example.application.views.masterdetail.MasterDetailView;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.HasComponents;
//import com.vaadin.flow.component.applayout.AppLayout;
//import com.vaadin.flow.component.applayout.DrawerToggle;
//import com.vaadin.flow.component.dependency.JsModule;
//import com.vaadin.flow.component.html.Span;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.FlexComponent;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.tabs.Tab;
//import com.vaadin.flow.component.tabs.Tabs;
//import com.vaadin.flow.component.tabs.TabsVariant;
//import com.vaadin.flow.router.RouteConfiguration;
//import com.vaadin.flow.router.RouterLink;
//import com.vaadin.flow.theme.Theme;
//import com.vaadin.flow.theme.lumo.Lumo;
//import ru.goryacms.dockerInitializr.views.initializr.DockerInitializrView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
///**
// * The main view is a top-level placeholder for other views.
// */
//@JsModule("./styles/shared-styles.js")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
//public class MainView extends AppLayout {
//
//    private final Tabs menu;
//
//    public MainView() {
//        setPrimarySection(Section.DRAWER);
//        DrawerToggle drawerToggle = new DrawerToggle();
//        addToNavbar(true, drawerToggle);
//        menu = createMenuTabs();
//
//        // HEADER
////        Icon drawer = VaadinIcon.MENU.create();
//        Span title = new Span("My application");
//        Icon help = VaadinIcon.QUESTION_CIRCLE.create();
//        HorizontalLayout header = new HorizontalLayout(menu, help);
////        header.expand(title);
//        header.setPadding(true);
//        header.setWidth("100%");
//
//        // WORKSPACE
//
//        VerticalLayout workspace = new VerticalLayout();
//        workspace.setSizeFull();
//
//        // FOOTER
//        Tab actionButton1 = new Tab(VaadinIcon.HOME.create(), new Span("Home"));
//        Tab actionButton2 = new Tab(VaadinIcon.USERS.create(), new Span("Customers"));
//        Tab actionButton3 = new Tab(VaadinIcon.PACKAGE.create(), new Span("Products"));
//        Tabs buttonBar = new Tabs(actionButton1, actionButton2, actionButton3);
//        HorizontalLayout footer = new HorizontalLayout(buttonBar);
//        footer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
//        footer.setWidth("100%");
//
//        // MAIN CONTAINER
////        setSizeFull();
////        setMargin(false);
////        setSpacing(false);
////        setPadding(false);
//        addToDrawer(header, workspace, footer);
//
////        DrawerToggle drawerToggle = new DrawerToggle();
////        addToNavbar(true, drawerToggle);
////        menu = createMenuTabs();
////
////
////        HorizontalLayout layout = new HorizontalLayout();
////        layout.getStyle().set("border", "1px solid #9E9E9E");
////        layout.setSpacing(true);
////        layout.add(menu, new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo"));
////        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
////
////        addToDrawer(layout);
////
////        addToDrawer(menu);
//    }
//
//    private static Tabs createMenuTabs() {
//        final Tabs tabs = new Tabs();
//        tabs.setOrientation(Tabs.Orientation.VERTICAL);
//        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
//        tabs.setId("tabs");
//        tabs.add(getAvailableTabs());
//        return tabs;
//    }
//
//    private static Tab[] getAvailableTabs() {
//        final List<Tab> tabs = new ArrayList<>();
//        tabs.add(createTab("Docker Initializr", DockerInitializrView.class));
//
////        tabs.add(createTab("Hello-World", HelloWorld.class));
//        return tabs.toArray(new Tab[tabs.size()]);
//    }
//
//    private static Tab createTab(String title, Class<? extends Component> viewClass) {
//        return createTab(populateLink(new RouterLink(null, viewClass), title));
//    }
//
//    private static Tab createTab(Component content) {
//        final Tab tab = new Tab();
//        tab.add(content);
//        return tab;
//    }
//
//    private static <T extends HasComponents> T populateLink(T a, String title) {
//        a.add(title);
//        return a;
//    }
//
//    @Override
//    protected void afterNavigation() {
//        super.afterNavigation();
//        selectTab();
//    }
//
//    private void selectTab() {
//        String target = RouteConfiguration.forSessionScope().getUrl(getContent().getClass());
//        Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
//            Component child = tab.getChildren().findFirst().get();
//            return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
//        }).findFirst();
//        tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
//    }
//}
