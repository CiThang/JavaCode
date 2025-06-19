package Restaurant.Part_01.loaderProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javafx.fxml.FXMLLoader;

@Component
public class FXMLLoaderProvider {

    @Autowired
    private ApplicationContext applicationContext;

    public FXMLLoader getLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(applicationContext::getBean);
        loader.setLocation(getClass().getResource(fxmlPath));
        return loader;
    }
}
