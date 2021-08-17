package globus.sdanilov.logistics.repositories;

import globus.sdanilov.logistics.models.SensorSnapshotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorValuesRepository extends JpaRepository<SensorSnapshotModel,Long> {

    public List<SensorSnapshotModel> findByTimeBetween(float start, float end);
}
