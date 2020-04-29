package com.sung.tagclouddemo.model;

/**
 * Create by sung at 2020-04-29
 *
 * @desc:
 * @notice:
 */
public class RapidMatchModel {
    public RapidMatchModel(String uid, String nickname, String fitness, String type) {
        this.uid = uid;
        this.nickname = nickname;
        this.fitness = fitness;
        this.type = type;
    }

    public String uid;
    public String nickname;
    public String fitness;
    public String type;
}