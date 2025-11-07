package com.jad.api;

import com.jad.model.SensorData;
import com.jad.report.spi.ReportType;

import java.util.List;

public interface IReportGenerator {
    void generate(ReportType reportType, List<SensorData> data);
}

