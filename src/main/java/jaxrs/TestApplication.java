package jaxrs;

import Rest.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
@ApplicationPath("/")
public class TestApplication extends Application {

    @Override
    public Set <Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(FicheResource.class);
        clazzes.add(SectionResource.class);
        clazzes.add(TableauKanbanResource.class);
        clazzes.add(TagResource.class);
        clazzes.add(UtilisateurResource.class);
        clazzes.add(OpenApiResource.class);
        clazzes.add(SwaggerResource.class);



        return clazzes;
    }
}
