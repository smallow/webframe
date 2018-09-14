package com.smallow.webframe.modular.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smallow.webframe.core.util.EnumUtil;
import com.smallow.webframe.modular.enums.GroupStateEnum;

import java.io.IOException;

public class GroupStateSerializer extends JsonSerializer<Integer> {

    @Override
    public void serialize(Integer integer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(EnumUtil.getByCode(integer, GroupStateEnum.class).getMsg());
    }
}
