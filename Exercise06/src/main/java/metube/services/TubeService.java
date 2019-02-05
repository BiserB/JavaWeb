package metube.services;

import metube.entities.Tube;
import metube.models.binding.TubeBindingModel;
import metube.models.view.TubeFullViewModel;
import metube.repositories.TubeRepository;
import metube.utils.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

public class TubeService {

    private final TubeRepository tubeRepository;
    private final ModelMapper mapper;

    @Inject
    public TubeService(TubeRepository tubeRepository, ModelMapper mapper) {
        this.tubeRepository = tubeRepository;
        this.mapper = mapper;
    }

    public void save(TubeBindingModel tubeModel) {

        Tube tube = mapper.map(tubeModel, Tube.class);

        this.tubeRepository.save(tube);
    }

    public List<String> getAllTubeTitles() {

        List<String> tubes = tubeRepository.getAllTubeTitles();

        Type listType = new TypeToken<List<String>>() {}.getType();

        List<String> models = mapper.map(tubes, listType);

        return  models;
    }

    public TubeFullViewModel getByTitle(String title) {

        Tube tube = tubeRepository.getByTitle(title);

        TubeFullViewModel model = mapper.map(tube, TubeFullViewModel.class);

        return model;
    }
}
