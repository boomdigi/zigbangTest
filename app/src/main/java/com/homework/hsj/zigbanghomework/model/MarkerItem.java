package com.homework.hsj.zigbanghomework.model;

/**
 * Created by boomd on 2017-05-21.
 */

public class MarkerItem {

    /*
    {
      "id": 5569,
      "name": "대우아이빌",
      "sido": "서울특별시",
      "gugun": "서초구",
      "dong": "잠원동",
      "bunji": "42-13",
      "lat": 37.51139337574741,
      "lng": 127.01835497289554,
      "households": 168,
      "buildDate": 200107,
      "score": 4.66667,
      "brand": "",
      "image": "https://i6.zigbang.com/v1/apartments/5569/profile.jpg?orientation=landscape",
      "price": 24000,
      "floorArea": 39.6,
      "marker": {
        "small": {
          "xxxh": {
            "base": "https://i6.zigbang.com/v1/marker/apartment.jpg?markerSizeName=xxxh&markerTypeName=Small_Apartment&datas=2.4%EC%96%B5%2C40%E3%8E%A1",
            "selected": "https://i6.zigbang.com/v1/marker/apartment.jpg?markerSizeName=xxxh&markerTypeName=Small_Apartment_Selected&datas=2.4%EC%96%B5%2C40%E3%8E%A1"
          }
        },
        "large": {
          "xxxh": {
            "base": "https://i6.zigbang.com/v1/marker/apartment.jpg?markerSizeName=xxxh&markerTypeName=Apartment&datas=2.4%EC%96%B5%2C40%E3%8E%A1%2C168%EC%84%B8%EB%8C%80%20%2F%202001%EB%85%84&brandName=",
            "selected": "https://i6.zigbang.com/v1/marker/apartment.jpg?markerSizeName=xxxh&markerTypeName=Apartment_Selected&datas=2.4%EC%96%B5%2C40%E3%8E%A1%2C168%EC%84%B8%EB%8C%80%20%2F%202001%EB%85%84&brandName="
          }
        }
      }
    },
     */

    int id;
    String name;
    String sido;
    String gugun;
    String dong;
    String bonji;
    long lat;
    long lng;
    int households;
    int buildDate;
    float score;
    String brand;
    String Image;
    int price;
    float floorArea;

    String markerSmallBase;
    String markerSmallSelected;
    String markerLargeBase;
    String markerLargeSelected;


}
