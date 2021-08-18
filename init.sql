create table snapshots
(
    id            SERIAL NOT NULL,
    snapshotTime  decimal NOT NULL,
    containerId   decimal NOT NULL,
    sensorId      decimal NOT NULL,
    snapshotValue decimal NOT NULL
);
