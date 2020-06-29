package ru.goryacms.dockerInitializr.views.initializr;

import com.github.appreciated.prism.element.Language;
import com.github.appreciated.prism.element.PrismHighlighter;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.stefan.LazyDownloadButton;
import ru.goryacms.dockerInitializr.MainLayout;
import ru.goryacms.dockerInitializr.dto.ServicesDto;
import ru.goryacms.dockerInitializr.models.Services;
import ru.goryacms.dockerInitializr.service.ServicesService;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Route(value = "", layout = MainLayout.class)
//@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Docker Initializr")
public class DockerInitializrView extends VerticalLayout {

    private final ServicesService services;

    private static String DOCKER_EXAMPLE_CONTENT;
    //            = "" +
//            "version: '2.1'\n" +
//            "\n" +
//            "services:\n" +
//            "\n" +
//            "  mongo:\n" +
//            "    image: mongo\n" +
//            "    restart: always\n" +
//            "    ports:\n" +
//            "      - 27017:27017\n" +
//            "    environment:\n" +
//            "      MONGO_INITDB_ROOT_USERNAME: manhattan\n" +
//            "      MONGO_INITDB_ROOT_PASSWORD: manhattan123\n" +
//            "      MONGO_INITDB_DATABASE: manhattan\n" +
//            "    volumes:\n" +
//            "      - ./mongo-init.js:/docker-entrypoint-initdb.d/mongo-init.js:ro\n" +
//            "\n" +
//            "  mongo-express:\n" +
//            "    image: mongo-express\n" +
//            "    restart: always\n" +
//            "    ports:\n" +
//            "      - 7999:8081\n" +
//            "    environment:\n" +
//            "      ME_CONFIG_MONGODB_ADMINUSERNAME: manhattan\n" +
//            "      ME_CONFIG_MONGODB_ADMINPASSWORD: manhattan123\n" +
//            "  apache:\n" +
//            "    image: httpd:2.4\n" +
//            "    volumes:\n" +
//            "      - ./htdocs/:/usr/local/apache2/htdocs/\n" +
//            "      - ./.htaccess:/usr/local/apache2/htdocs/.htaccess\n" +
//            "      - ./httpd.conf:/usr/local/apache2/conf/httpd.conf\n" +
//            "    ports:\n" +
//            "      - 7084:80\n" +
//            "    expose:\n" +
//            "      - 7084\n" +
//            "\n" +
//            "  nginx:\n" +
//            "    image: nginx:1.13\n" +
//            "    ports:\n" +
//            "      - 8084:80\n" +
//            "    expose:\n" +
//            "      - 8084\n" +
//            "    depends_on:\n" +
//            "      - apache" +
//            "";
    FormLayout result = new FormLayout();

    //    @SneakyThrows
    public DockerInitializrView(ServicesService services) {
        this.services = services;
        // Header
        Label title = new Label("Docker");

        HorizontalLayout header = new HorizontalLayout(title);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setFlexGrow(1, title);
        header.setPadding(true);
        header.setSpacing(true);

        // body
        Paragraph text = new Paragraph("Choose services which you want to add at docker-compose");



        FormLayout nameLayout = new FormLayout();
        Dialog dependencyDialog = createAddDependencyPanel();
        Button dependency = new Button("Add services... CTRL+B",
                e -> dependencyDialog.open()
        );
        dependency.setWidth("100px");
        dependency.addClickShortcut(Key.KEY_B, KeyModifier.CONTROL);
        dependency.addClassName("buttons");


        Paragraph noDependencySelected = new Paragraph("No dependency selected");
        noDependencySelected.addClassName("noDependencySelected");
        result.add(noDependencySelected);

        nameLayout.add(dependency, result);
        nameLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("25em", 1));
//        nameLayout.setWidth("350px");

        VerticalLayout content = new VerticalLayout(text, nameLayout);
        content.setPadding(true);

        // footer


        // Provide a callback to create the file name on click time


//        StreamResource resource = new StreamResource("demo.zip", () -> new ByteArrayInputStream(baos.toByteArray()));


//        LazyDownloadButton generate = new LazyDownloadButton("Generate CTRL+\u23CE", new Icon(VaadinIcon.OUTBOX),
//                () -> "demo.zip",
//                () -> {
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    try (ZipOutputStream zos = new ZipOutputStream(baos)) {
//                        byte[] xmlFromContainer = DOCKER_EXAMPLE_CONTENT.getBytes();
//                        zos.putNextEntry(new ZipEntry("docker-compose.yml"));
//                        zos.write(xmlFromContainer);
//                        zos.flush();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    return new ByteArrayInputStream(baos.toByteArray());
//                }
//        );

        Button generate = new Button("Generate CTRL+\u23CE", new Icon(VaadinIcon.OUTBOX));

        generate.addClickListener((event) -> {
            System.out.println(1);
            Supplier<String> fileNameCallback = () -> "demo.zip";
            System.out.println(2);
            InputStreamFactory inputStreamCallback = () -> {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (ZipOutputStream zos = new ZipOutputStream(baos)) {
                    byte[] xmlFromContainer = DOCKER_EXAMPLE_CONTENT.getBytes();
                    zos.putNextEntry(new ZipEntry("docker-compose.yml"));
                    zos.write(xmlFromContainer);
                    zos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new ByteArrayInputStream(baos.toByteArray());
            };
            System.out.println(3);
            this.getParent().ifPresent((component) -> {
                System.out.println(4);
                Anchor anchor = null;
                Objects.requireNonNull(fileNameCallback, "File name callback must not be null");
                Objects.requireNonNull(inputStreamCallback, "Input stream callback must not be null");
                System.out.println(5);
                if (anchor == null) {
                    System.out.println(6);
                    anchor = new Anchor();
                    Element anchorElement = anchor.getElement();
                    anchorElement.setAttribute("download", true);
                    anchorElement.getStyle().set("display", "none");
                    System.out.println(7);
                    component.getElement().appendChild(new Element[]{anchor.getElement()});
//                    anchorElement.addEventListener("click", (event1) -> {
//                        System.out.println(8);
//                        this.fireEvent(new LazyDownloadButton.DownloadStartsEvent(generate, true, event1));
//                    });
                }
                System.out.println(8);
                Optional<UI> optionalUI = this.getUI();
                Anchor finalAnchor = anchor;
                System.out.println(9);
                Executors.newSingleThreadExecutor().execute(() -> {
                    System.out.println(10);
                    try {
                        System.out.println(11);
                        InputStream inputStream = inputStreamCallback.createInputStream();
                        optionalUI.ifPresent((ui) -> {
                            System.out.println(12);
                            ui.access(() -> {
                                System.out.println(13);
                                StreamResource href = new StreamResource((String) fileNameCallback.get(), () -> {
                                    return inputStream;
                                });
                                href.setCacheTime(0L);
                                finalAnchor.setHref(href);
                                finalAnchor.getElement().callJsFunction("click", new Serializable[0]);
                            });
                        });
                    } catch (Exception var5) {
                        System.out.println(14);
                        throw new RuntimeException(var5);
                    }
                });
            });
        });

        generate.click();
        generate.addClickShortcut(Key.ENTER, KeyModifier.CONTROL);
        generate.addClassName("buttons");

        Button explore = new Button("Explore CTRL+\u23B5", new Icon(VaadinIcon.PRINT));
        explore.addClickShortcut(Key.SPACE, KeyModifier.CONTROL);
        explore.addClickListener(event -> {
            PrismHighlighter prismHighlighter = new PrismHighlighter(DOCKER_EXAMPLE_CONTENT
                    , Language.docker);

            Dialog dialog = new Dialog();
            dialog.setModal(true);
            dialog.setDraggable(true);
            dialog.setResizable(true);
            dialog.setHeight("500px");
            dialog.add(prismHighlighter);


            dialog.open();
        });
        explore.addClassName("buttons");

        Button share = new Button("Share...");
        share.addClassName("buttons");

        HorizontalLayout footer = new HorizontalLayout(generate, explore, share);
        footer.setPadding(true);
        footer.setSpacing(true);

        add(header, content, footer);
    }

    private Dialog createAddDependencyPanel() {
        Dialog dialog = new Dialog();
        dialog.setModal(true);
        dialog.setDraggable(true);
        dialog.setResizable(true);

        List<ServicesDto> names = services.getAllServices();

        DependencyForm form = new DependencyForm(dialog, names);
        Div content = new Div(form);
        content.addClassName("content");
        content.setSizeFull();

        dialog.addDetachListener(event -> {
            List<ServicesDto> dependencies = form.getCheckedDependencies();
            formContent(dependencies);
//            Notification.show("list = " + dependencies);
            Grid<ServicesDto> grid = new Grid<>();
            grid.setHeightByRows(true);
            grid.addColumn(ServicesDto::getName).setHeader("Dependency");
            grid.addColumn(ServicesDto::getImage).setHeader("Image");
            grid.setItems(dependencies);
            result.removeAll();
            result.add(grid);
        });

        dialog.add(content);
        return dialog;
    }

    private void formContent(List<ServicesDto> dependencies) {
        StringBuilder contentBuilder = new StringBuilder().append("version: '2.1'\n\nservices:\n\n");
        String br = "\n";
        String serviceSpace = "  ";
        String parameterSpace = "    ";
        String valueSpace = "      ";
        dependencies.forEach(services -> {
            contentBuilder.append(serviceSpace).append(services.getName()).append(":").append(br);
            // image
            if (services.getUseImage()) {
                contentBuilder.append(parameterSpace).append("image: ").append(services.getImage()).append(br);
            }
            // container_name
            if (services.getUseContainerName()) {
                contentBuilder.append(parameterSpace).append("container_name: ").append(services.getContainerName()).append(br);
            }
            // build
            if (services.getUseBuild()) {
                contentBuilder.append(parameterSpace).append("build: ").append(services.getBuild()).append(br);
            }
            // restart
            if (services.getUseRestart()) {
                contentBuilder.append(parameterSpace).append("restart: ").append(services.getRestart()).append(br);
            }
            // command
            if (services.getUseCommand()) {
                contentBuilder.append(parameterSpace).append("command: ").append(services.getCommand()).append(br);
            }
            // hostname
            if (services.getUseHostname()) {
                contentBuilder.append(parameterSpace).append("hostname: ").append(services.getHostname()).append(br);
            }
            // mem_limit
            if (services.getUseMemLimit()) {
                contentBuilder.append(parameterSpace).append("mem_limit: ").append(services.getMemLimit()).append(br);
            }
            // memswap_limit
            if (services.getUseMemswapLimit()) {
                contentBuilder.append(parameterSpace).append("memswap_limit: ").append(services.getMemswapLimit()).append(br);
            }

            // ports
            if (services.getUsePorts()) {
                contentBuilder.append(parameterSpace).append("ports: ").append(br);
                services.getPorts().forEach(port -> {
                    contentBuilder.append(valueSpace).append("- ").append(port.getApp()).append(":").append(port.getDocker()).append(br);
                });
            }
            // expose
            if (services.getUseExpose()) {
                contentBuilder.append(parameterSpace).append("expose: ").append(br);
                services.getExposes().forEach(expose -> {
                    contentBuilder.append(valueSpace).append("- ").append(expose.getPort()).append(br);
                });
            }
            // environment
            if (services.getUseEnvironments()) {
                contentBuilder.append(parameterSpace).append("environment: ").append(br);
                services.getEnvironments().forEach(env -> {
                    contentBuilder.append(valueSpace).append(env.getValueName()).append(br);
                });
            }
            // volumes
            if (services.getUseVolumes()) {
                contentBuilder.append(parameterSpace).append("volumes: ").append(br);
                services.getVolumes().forEach(volume -> {
                    contentBuilder.append(valueSpace).append("- ").append(volume.getApp()).append(":").append(volume.getDocker()).append(br);
                });
            }
            // networks
            if (services.getUseNetworks()) {
                contentBuilder.append(parameterSpace).append("networks: ").append(br);
                services.getNetworks().forEach(network -> {
                    contentBuilder.append(valueSpace).append("- ").append(network.getValueName()).append(br);
                });
            }
            // depends_on
            if (services.getUseDependsOn()) {
                contentBuilder.append(parameterSpace).append("depends_on: ").append(br);
                services.getDepependsOns().forEach(dependsOn -> {
                    contentBuilder.append(valueSpace).append("- ").append(dependsOn.getValueName()).append(br);
                });
            }
        });
        DOCKER_EXAMPLE_CONTENT = contentBuilder.toString();
    }

}
