package com.bin.config;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 自定义 LocalDate 类型转换器
 * 继承 PropertyEditorSupport，通过 AbstractBeanFactory.registerCustomEditor 进行注册；
 */
public class CustomLocalDateEditor extends PropertyEditorSupport {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    /**
     * this.customEditors.forEach((requiredType, editorClass) ->
     *  registry.registerCustomEditor(requiredType, BeanUtils.instantiateClass(editorClass)));
     *  默认通过 class 反射创建的 PropertyEditorSupport 对象，因此必须提供无参构造函数
     */
    public CustomLocalDateEditor() {
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (!StringUtils.hasText(text))
            setValue(null);
        else
            try {
                text = text.trim();
                setValue(LocalDate.parse(text, dateTimeFormatter));
            } catch (Exception e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
            }
    }

    @Override
    public String getAsText() {
        LocalDate localDate = (LocalDate) getValue();
        return localDate == null ? "" : localDate.format(dateTimeFormatter);
    }
}
