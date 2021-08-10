package globus.sdanilov.logistics.repositories;

import globus.sdanilov.logistics.models.SensorSnapshotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorValuesRepository extends JpaRepository<SensorSnapshotModel,Long> {
}
