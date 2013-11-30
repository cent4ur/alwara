// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Managing locale changes.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class LocaleBean implements Serializable {

    private static final long serialVersionUID = -3986850539098745622L;
    private static final Logger logger = Logger.getLogger(LocaleBean.class.getName());
    private Locale locale;
    private HashMap<String, Locale> locales;

    @PostConstruct
    public void init() {
        locales = new LinkedHashMap<String, Locale>();
        locales.put("English", new Locale("en"));
        locales.put("Magyar", new Locale("hu"));

        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        if (!locales.containsValue(locale)) {
            logger.info("init() - Unknown locale, setting English.");
            locale = locales.get("English");
            FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        }
        logger.info("init() - Current locale: " + locale.getLanguage());
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public HashMap<String, Locale> getLocales() {
        return locales;
    }

    public void changeLocale() {
        logger.info("changeLanguage() - New locale: " + locale.getLanguage());
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
