package com.jad.api;

import java.util.List;

public interface IReportGenerator {
    void generate(ReportType reportType, List<SensorData> data);
}

