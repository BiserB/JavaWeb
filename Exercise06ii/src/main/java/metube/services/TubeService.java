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

    public List<TubeFullViewModel> getAll() {

        List<Tube> tubes = tubeRepository.findAll();

        Type listType = new TypeToken<List<TubeFullViewModel>>() {}.getType();

        List<TubeFullViewModel> models = mapper.map(tubes, listType);

        //models.forEach(m -> m.getTitle());

        return  models;
    }

    public TubeFullViewModel getById(String id) {

        Tube tube = tubeRepository.getById(id);

        TubeFullViewModel model = mapper.map(tube, TubeFullViewModel.class);

        return  model;
    }


    public TubeFullViewModel getByTitle(String title) {

        Tube tube = tubeRepository.getByTitle(title);

        TubeFullViewModel model = mapper.map(tube, TubeFullViewModel.class);

        return model;
    }
}
