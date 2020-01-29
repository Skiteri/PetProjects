package ru.restoraunt.service;

import org.springframework.stereotype.Service;
import ru.restoraunt.entity.Goods;
import ru.restoraunt.repos.GoodsRepo;

@Service
public class GoodsService {
    private final GoodsRepo goodsRepo;

    public GoodsService(GoodsRepo goodsRepo) {
        this.goodsRepo = goodsRepo;
    }

    public GoodsRepo getAll(){
        return goodsRepo;
    }

    public void save(Goods goods) {
        goodsRepo.save(goods);
    }

    public Goods findById(Integer id){
        return goodsRepo.findByRowid(id);
    }
}
