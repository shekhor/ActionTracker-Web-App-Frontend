package com.tigerit.actiontracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequest implements Serializable {

    Integer page;

    Integer size;
}
