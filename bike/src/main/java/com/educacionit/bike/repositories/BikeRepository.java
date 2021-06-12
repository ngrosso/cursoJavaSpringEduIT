package com.educacionit.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.bike.models.Bike;

// Los generics tienen que usarse con objetos como Long, no atomico como int
public interface BikeRepository extends JpaRepository<Bike, Long> {

	// Permite inyectar una instancia para obtener datos de la tabla
	// El extend nos permite la mayoria de las operaciones CRUD
}
