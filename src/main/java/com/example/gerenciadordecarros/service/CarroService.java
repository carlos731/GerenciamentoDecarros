package com.example.gerenciadordecarros.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordecarros.domain.Carro;
import com.example.gerenciadordecarros.repository.CarroRepository;

@Service
public class CarroService {

    @Autowired
    CarroRepository repository;

    public Carro findOne(int id) throws ObjectNotFoundException {
        Optional<Carro> carro = repository.findById(id);

        return carro.orElseThrow(() -> new ObjectNotFoundException("Carro " + id + " não encontrado", null));
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    public List<Carro> saveAll(List<Carro> carro) {
        return repository.saveAll(carro);
    }

    public Carro update(Carro carro) throws ObjectNotFoundException {
        Carro carroExistente = findOne(carro.getId());
        carroExistente.setModelo(carro.getModelo());
        carroExistente.setFabricante(carro.getFabricante());
        carroExistente.setDocumento(carro.getDocumento());
        carroExistente.setChave(carro.getChave());
        carroExistente.setAcessorios(carro.getAcessorios());
        return save(carroExistente);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
