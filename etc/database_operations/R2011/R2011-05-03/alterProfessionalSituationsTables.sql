alter table `CONTRACT_SITUATION` add `IN_EXERCISE` tinyint(1), add `GIVE_CREDITS` tinyint(1), add `MUST_HAVE_ASSOCIATED_EXEMPTION` tinyint(1);
update `CONTRACT_SITUATION` set IN_EXERCISE = !END_SITUATION;
update `CONTRACT_SITUATION` set GIVE_CREDITS = !SERVICE_EXEMPTION;
update `CONTRACT_SITUATION` set MUST_HAVE_ASSOCIATED_EXEMPTION = SERVICE_EXEMPTION;
alter table `SERVICE_EXEMPTION` add `GIVE_CREDITS_IF_CATEGORY_BELLOW_ASSISTANT` tinyint(1) default '0', add `GIVE_CREDITS` tinyint(1) default '0', add `IS_SABATICAL_OR_EQUIVALENT` tinyint(1) default '0';
alter table `GRANT_OWNER_EQUIVALENT` add `GIVE_CREDITS_IF_CATEGORY_BELLOW_ASSISTANT` tinyint(1)default '0', add `GIVE_CREDITS` tinyint(1) default '0', add `IS_SABATICAL_OR_EQUIVALENT` tinyint(1) default '0';
alter table `TEACHER_CREDITS` add `TOTAL_CREDITS` text;