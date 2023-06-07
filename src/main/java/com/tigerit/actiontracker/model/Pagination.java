/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tigerit.actiontracker.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pagination implements Serializable{
    private Integer totalCount;

    private Integer page;

    private Integer size;
}
