package com.foodfinder.oseek.domain.keyword;


public enum FoodKeyword {
    CLEAN("매장이 청결해요"),
    DELICIOUS("음식이 맛있어요");

    private final String keywordDetail;

    FoodKeyword(String keywordDetail){
        this.keywordDetail = keywordDetail;
    }


    public String getKeywordDetail(){return this.keywordDetail;}

}
