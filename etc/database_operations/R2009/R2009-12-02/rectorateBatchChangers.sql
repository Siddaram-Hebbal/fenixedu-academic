alter table `RECTORATE_SUBMISSION_BATCH` add column `OID_CREATOR` bigint(20), add column `OID_RECEPTOR` bigint(20), add column `OID_SUBMITTER` bigint(20), add index (`OID_CREATOR`), add index (`OID_RECEPTOR`), add index (`OID_SUBMITTER`);