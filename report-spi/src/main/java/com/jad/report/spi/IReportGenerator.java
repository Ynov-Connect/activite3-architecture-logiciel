package com.jad.report.spi;

import com.jad.model.SensorData;

import java.util.List;

/**
 * Service Provider Interface pour la génération de rapports.
 * Les implémentations de cette interface doivent être découvertes via le mécanisme Java SPI.
 */
public interface IReportGenerator {
    /**
     * Génère un rapport à partir des données de capteurs.
     * 
     * @param reportType Le type de rapport à générer
     * @param data Les données de capteurs à inclure dans le rapport
     */
    void generate(ReportType reportType, List<SensorData> data);
}

